package cn.dq.www.guangchangan.server;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import cn.dq.www.guangchangan.utils.DownLoadEvent;
import cn.dq.www.guangchangan.utils.ShareData;
import cn.dq.www.guangchangan.utils.downloader.Constant;
import cn.dq.www.guangchangan.utils.downloader.Downloader;
import cn.dq.www.guangchangan.utils.downloader.DownloaderInfo;
import cn.dq.www.guangchangan.utils.downloader.FileState;
import cn.dq.www.guangchangan.utils.downloader.SqliteDao;
import de.greenrobot.event.EventBus;


/**
 * 
 * 项目名称：MultithreadedDownload 类名称：DownloadService 类描述： 后台下载 创建人：wpy
 * 创建时间：2014-10-10 下午5:18:31
 * 
 */
public class DownloadService extends Service {

	private Context mContext;
	
	// 下载器
	private Downloader downloader;

	private SqliteDao dao;
	/**
	 * 存放各个下载器
	 */
	private Map<String, Downloader> downloaders = new HashMap<String, Downloader>();

	/**
	 * 存放每个下载文件的总长度
	 */
	private Map<String, Integer> fileSizes = new HashMap<String, Integer>();
	/**
	 * 存放每个下载文件完成的长度
	 */
	private Map<String, Integer> completeSizes = new HashMap<String, Integer>();
	
	private ShareData shareData;

	/**
	 * 消息处理 接收Download中每个线程传输过来的数据
	 */
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1) {
				String url = (String) msg.obj;
				int length = msg.arg1;

				int completeSize = completeSizes.get(url);
				completeSize = completeSize + length;
				completeSizes.put(url, completeSize);


				int fileSize = fileSizes.get(url);
				
				//Log.e("czq", "download fileSizes：" + fileSize);
				//Log.e("czq", "download completeSize：" + completeSize);
				
				double progess = (double)completeSize / (double)fileSize * 100.0;
				if (completeSize >= fileSize) {// 下载完成
//					Log.e("czq", "download complete：" + completeSize + " fileSize = " + fileSize);
					if(null != dao)
						dao.updataStateByUrl(url);
					if(null != downloaders && downloaders.size() > 0 && downloaders.containsKey(url)){
						EventBus.getDefault().post(new DownLoadEvent((int)progess, url, downloaders.get(url).getFileAction()));
						downloaders.get(url).delete(url);
						downloaders.remove(url);
						shareData.setDownloaders(downloaders);
					}
					if (null == downloaders || downloaders.isEmpty()) {// 如果全部下载完成，关闭service
//						stopSelf();
					}
				}
				
				if(null != downloaders && downloaders.size() > 0 && downloaders.containsKey(url))
					EventBus.getDefault().post(new DownLoadEvent((int)progess, url, downloaders.get(url).getFileAction()));
				
			}else if (msg.what == 2) {//错误处理
				String url = (String) msg.obj;
				int length = msg.arg1;
				if(null != dao)
					dao.updataStateByUrl(url);
				
				if(null != downloaders && downloaders.size() > 0 && downloaders.containsKey(url)){
					EventBus.getDefault().post(new DownLoadEvent(length, url, downloaders.get(url).getFileAction()));
					downloaders.get(url).delete(url);
					downloaders.remove(url);
					shareData.setDownloaders(downloaders);
					
				}
				
				
				if (null == downloaders || downloaders.isEmpty()) {// 如果全部下载完成，关闭service
//					stopSelf();
				}
				
				
			}
		};
	};

	@Override
	public void onCreate() {
		super.onCreate();
		
		this.mContext = this;
		shareData = ShareData.getInstance();
		//注册事件总线
		EventBus.getDefault().register(mContext);
		
		dao = new SqliteDao(this);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(intent != null)
		{
		String urlPath = intent.getStringExtra("downloadUrl");
		String name = intent.getStringExtra("docName");
//		String flag = intent.getStringExtra("flag");
		String flag = intent.getStringExtra("flag");
		int action = intent.getIntExtra("action", -1);
		int fileAction = intent.getIntExtra("fileAction", -1);
		
//		Log.d("czq", "on start action = " + action);
//		if (flag.equals("startDownload")) {
		if (Constant.DOWNLOAD == action) {
			startDownload(name, urlPath, true, fileAction);
		}
//		if (flag.equals("changeState")) {
		else if (Constant.PAUSE == action) {
			changeState(name, urlPath, fileAction);
		}else if(Constant.CANCEL == action) {
			dao.updataStateByUrl(urlPath);
			if(null != downloaders && null != downloaders.get(urlPath)){
				downloaders.get(urlPath).setCancel();
				downloaders.get(urlPath).delete(urlPath);
				downloaders.remove(urlPath);
				shareData.setDownloaders(downloaders);
			}
			
			if (downloaders.isEmpty()) {// 如果全部下载完成，关闭service
//				stopSelf();
			}
		}
		}
		return Service.START_STICKY;//super.onStartCommand(intent, flags, startId);
		//return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	/**
	 * 开始下载
	 * 
	 * @param urlPath
	 *            下载地址
	 */
	private void startDownload(final String name, final String urlPath,
			final boolean isFirst, final int fileAction) {
//		Log.e("czq", "文件的名称：" + name);
//		Log.e("czq", "文件的下载地址：" + urlPath);
		// 初始化一个下载器
		downloaders = shareData.getDownloaders();
		downloader = downloaders.get(urlPath);
		if (null == downloader) {
			downloader = new Downloader(name, urlPath, Constant.LOCALPATH,
					Constant.THREADCOUNT, this, mHandler, fileAction);
			downloaders.put(urlPath, downloader);
			shareData.setDownloaders(downloaders);
		}
		if (downloader.isDownloading()) {
			return;
		}

		new Thread() {
			public void run() {
				DownloaderInfo downloaderInfo = downloader.getDownloaderInfos();
				completeSizes.put(urlPath, downloaderInfo.getComplete());

				if (fileSizes.get(urlPath) == null) {
					fileSizes.put(urlPath, downloaderInfo.getFileSize());
				}

				// FileState state = dao.query(urlPath);
				if (isFirst) {
//					Log.e("czq", "文件：" + name + "第一次下载");
					FileState fileState = new FileState(name, urlPath, 1,
							downloaderInfo.getComplete(),
							downloaderInfo.getFileSize());
					dao.saveFileState(fileState);
				}

				downloader.download();
			};
		}.start();
	}

	/**
	 * 更改下载状态（若文件正在下载，就暂停；若暂停，则开始下载）
	 * 
	 * @param url
	 *            下载地址
	 */
	public void changeState(String name, String url, int fileAction) {
		Downloader loader = downloaders.get(url);
		if (loader != null) {
//			Log.d("czq", "loader.isPause() ? " + loader.isPause());
			
			if (loader.isDownloading()) {// 正在下载
				loader.setPause();
			} else if (loader.isPause()) {// 暂停
				loader.reset();
				this.startDownload(name, url, false, fileAction);
			}
		} else {
			startDownload(name, url, false, fileAction);
		}
	}
	
	public void onEventBackgroundThread(DownLoadEvent event){}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		//注销EventBus
        EventBus.getDefault().unregister(this);
		Log.v("ShareDocDownloadService", "ShareDocDownloadService 服务已关闭");
	}
}
