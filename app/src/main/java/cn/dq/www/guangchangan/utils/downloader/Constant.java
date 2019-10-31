package cn.dq.www.guangchangan.utils.downloader;

/**
 * 
 * 项目名称：MultithreadedDownload 类名称：Constant 类描述： 常量 创建人：wpy 创建时间：2014-10-13
 * 上午10:23:13
 * 
 */
public class Constant {
	/**
	 * 下载的url地址
	 */
	public static final String URL1 = "http://downloadc.dewmobile.net/z/kuaiya282.apk";
	public static final String URL2 = "http://gdown.baidu.com/data/wisegame/1b9392eadc3bddf1/WeChat_480.apk";

	/**
	 * 本地保存地址
	 */
	public static final String LOCALPATH = "/mnt/sdcard/qtoneDownloader/";
	
	public static final String LOCALPREVIEWPATH = "/mnt/sdcard/qtonePreview/";
	/**
	 * 下载的线程数量
	 */
	public static final int THREADCOUNT = 1;
	/**
	 * 下载管理广播的action
	 */
	public static final String DOWNLOADMANAGEACTION = "com.wpy.multithreadeddownload.DownloadManageActivity";
	
	public final static int DOWNLOAD = 0;
	public final static int PAUSE = 1;
	public final static int CANCEL = 2;
	public static final String SQLPWD =  "downloadservice";
}
