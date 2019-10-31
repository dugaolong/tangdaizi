package cn.dq.www.guangchangan.utils;

public class DownLoadEvent {
	
	public int fileAction;
	public int completeSize; 
    public String url;
    
    public DownLoadEvent(int completeSize, String url, int fileAction) {
    	this.completeSize = completeSize;
    	this.fileAction = fileAction;
    	this.url = url;
    }
    
	public int getCompleteSize() {
		return completeSize;
	}
	public void setCompleteSize(int completeSize) {
		this.completeSize = completeSize;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public int getFileAction() {
		return fileAction;
	}

	public void setFileAction(int fileAction) {
		this.fileAction = fileAction;
	} 

	
}
