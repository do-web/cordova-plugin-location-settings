package com.doweb.cordova.settings;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class Settings extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    try {

    	Context context=this.cordova.getActivity().getApplicationContext();
        Intent dialogIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
               dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(dialogIntent);
        callbackContext.success();
        return true;
    } catch (Exception e) {
        callbackContext.error(e.getMessage());
        return false;
    }
  }
}