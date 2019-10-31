/**
 *Copyright (C) 2014 Guangzhou QTONE Technologies Ltd.
 *
 * 本代码版权归广州全通教育股份有限公司所有，且受到相关的法律保护。没有经过版权所有者的书面同意，
 * 任何其他个人或组织均不得以任何形式将本文件或本文件的部分代码用于其他商业用途。
 * @date 2014年10月15日 上午9:36:49 
 * @version V1.0
*/
package cn.dq.www.guangchangan.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.dq.www.guangchangan.MyApplication;
import cn.dq.www.guangchangan.utils.downloader.Downloader;


/** 
 * 共用数据
 * @ClassName ShareData 
 * @date 2014年10月15日 上午9:36:49  
 */
public class ShareData {

	public long datePickerTime;
	private List<String> check_groups = new ArrayList<String>();//通讯录选中的群组
	private static ShareData shareData = null;
	private String dt="0";
	private ShareData(){};
	private boolean isSwitching;
	public static final String HAHAHA = "wenwenliuyuanzhiba";
	/*选中的联系人群组链表,为二级链表， 其中的子链表contactsGroupsList包含本组所有的联系人
	 * 其中ContactsGroups被设置成checked状态说明整组被选中，子链表中contactsGroupsList
	 * 所有人相应也全被选中，否则说明contactsGroupsList只有部分人被选中。当然每个群组至少有
	 * 1人被选中，否则不应添加至此链表。Activity使用时需要先new、初始化，然后设置到ShareData中，
	 * 在选择接收人 界面去更新，在当前Activity onResume中重新去获取更新。
	 * */

	//分享到微信的bannerid 或者 和校园新闻id
	public static String shareId = "0";
	public static int weChatLoginAddress;//微信登录位置：1：登录页面，2：我的资料
	public static int weChatShareAddress;//微信分享 1:分享成功
	private int checkedContactsCount;
	private boolean isAllContactsChecked;//广东发通知选择联系人中全选标记位

	public static String newSystemMsgContent = "";//新系统消息内容
	public static String newSystemMsgNumber = "0";//新系统消息个数
	public static long newSystemMsgDt = 0l;//新系统消息时间

	public static String newRecommendContent = "";//新系统消息内容
	public static String newRecommendNumber = "0";//新系统消息个数
	public static long newRecommendDt = 0l;//新系统消息时间

	//存放各个下载器
    private Map<String, Downloader> downloaders = new HashMap();

	/**
	 * 教师类型
	 */
	public static final int ROLE_TEACHER_TYPE = 1;

	/**
	 * 家长类型
	 */
	public static final int ROLE_PARENT_TYPE = 2;
	/**
	 * 学生类型
	 */
	public static final int ROLE_STUDENT_TYPE = 3;
	//学生证的经纬度信息
	public static String LATITUDE="latitude";
	public static String LONGITUDE="longitude";
	public static String LOCATIONTIME="locationTime";
	public static String LOCATIONNAME="locationName";
	public static String LOCATIONTYPE="locationType";
	//家长手机的经纬度信息
	public static String LATITUDEPHONE="latitudephone";
	public static String LONGITUDEPHONE="longitudephone";
	public static String LOCATIONTIMEPHONE="locationTimephone";
	public static String LOCATIONNAMEPHONE="locationNamephone";
	public static String LOCATIONTYPEPHONE="locationTypephone";

	public void setSwitching(){
		isSwitching = false;
	}
	
	/**
	 * oa联系人类型
	 */
	public static final int ROLE_OA_PERSON_TYPE = 4;

	/**
	 * 教育直通车
     */
	public static EducationBus educationBus;
	//邀请登陆的发送人的手机号码
	public static String send = "";//
	//用户是否是第一次绑定学生证
	public static String USERBINDCARD = "userBindCard";//

	public static synchronized ShareData getInstance(){
		if(shareData == null){
			shareData = new ShareData();
		}
		return shareData;
	}
	
	public List<String> getCheck_groups() {
		return check_groups;
	}

	public void setCheck_groups(List<String> check_groups) {
		this.check_groups = check_groups;
	}


	public int getCheckedContactsCount() {
		return checkedContactsCount;
	}

	public void setCheckedContactsCount(int checkedCount) {
		this.checkedContactsCount = checkedCount;
	}




	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}
	
	//读取渠道ID的代码
	private int getChannelID() {
		try {
			PackageManager packageManager =MyApplication.getAppContext().getPackageManager();
			ApplicationInfo applicationInfo = packageManager.getApplicationInfo(MyApplication.getAppContext().getPackageName(), PackageManager.GET_META_DATA);
			if (applicationInfo != null && applicationInfo.metaData != null) {
				return applicationInfo.metaData.getInt("CHANNEL_ID");
			} else {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}



	

	public Map<String, Downloader> getDownloaders() {
		return downloaders;
	}

	public void setDownloaders(Map<String, Downloader> downloaders) {
		this.downloaders = downloaders;
	}
	
	public void setDownloadersItem(String urlstr, Downloader downloader) {
		this.downloaders.put(urlstr, downloader);
	}



	public boolean isAllContactsChecked() {
		return isAllContactsChecked;
	}

	public void setAllContactsChecked(boolean isAllContactsChecked) {
		this.isAllContactsChecked = isAllContactsChecked;
	}


	public static EducationBus getEducationBus() {
		return educationBus;
	}

	public static void setEducationBus(EducationBus educationBus) {
		ShareData.educationBus = educationBus;
	}

}
