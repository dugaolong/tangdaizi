package cn.dq.www.guangchangan.utils;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;


/**
 * 
 * <p> Title: CustomProgressDialog.java </p>
 * <p> Description: </p>
 * <p> Copyright：Copyrigth (c) 2014 </p> 
 * <p> Company:Monda Group </P>
 *
 * @author yaoshiqing@126.com
 * @Time 2014年11月19日
 * @version 1.0.0
 */
public class CustomProgressDialog extends Dialog {

	public CustomProgressDialog(Context context) {
		super(context, cn.dq.www.guangchangan.R.style.custom_dialog);
		this.setContentView(cn.dq.www.guangchangan.R.layout.progress_dialog);
		setCancelable(true);
	}

	public void setMessage(CharSequence message) {
		((TextView) findViewById(cn.dq.www.guangchangan.R.id.progress_dialog_msg)).setText(message);
	}
	
}