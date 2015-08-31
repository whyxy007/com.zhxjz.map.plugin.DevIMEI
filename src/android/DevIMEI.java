package com.zhxjz.map.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.view.Display;
import android.view.WindowManager;

/**
 * 获取设备IMEI的插件
 * 
 * @author yangxy
 * 
 */
public class DevIMEI extends CordovaPlugin {

	@SuppressWarnings("deprecation")
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			WindowManager wm = (WindowManager) this.webView.getContext().getSystemService("window");
			Display display = wm.getDefaultDisplay();
			
			int screenWidth  = display.getWidth();
			int screenHeight = display.getHeight();
			JSONArray arr = new JSONArray();
			arr.put(0, screenWidth);
			arr.put(1, screenHeight);
			callbackContext.success(arr);
			
			return true;
		} catch (Exception e) {
			callbackContext.error(e.getMessage());
			return false;
		}
	}

}
