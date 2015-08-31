package com.zhxjz.map.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * 获取设备IMEI的插件
 * 
 * @author yangxy
 * 
 */
public class DevIMEI extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		try {
			JSONArray arr = new JSONArray();
			Context context = this.webView.getContext();
			if (action.equals("getIMEI")) {
				String devIMEI = getIMEI(context);
				arr.put(0, devIMEI);
			}
			callbackContext.success(arr);
			return true;
		} catch (Exception e) {
			callbackContext.error(e.getMessage());
			return false;
		}
	}

	private String getIMEI(Context context) {
		return ((TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
	}

}
