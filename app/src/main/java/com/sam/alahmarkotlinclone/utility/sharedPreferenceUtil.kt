package com.sam.alahmarkotlinclone.utility

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceUtil {

    companion object{

        private val sharedPreferences: SharedPreferences? = null

        fun init(context: Context) {
            if (sharedPreferences == null) {
                sharedPreferences ==
                    context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
            }
        }


        fun writeToSharedPreferences(key: String?, value: String?) {
            val editor = sharedPreferences?.edit()
            editor?.putString(key, value)
            editor?.apply()
        }


        fun clearSharedPreferences() {
            val editor = sharedPreferences?.edit()
            editor?.clear()
            editor?.apply()
        }


        fun readFromSharedPreferences(key: String?): String? {
            return sharedPreferences?.getString(key, null)
        }


        // write for get set method for particular stuff...
        fun saveAccessToken(accessToken: String?) {
            sharedPreferences?.edit()?.putString(StaticKey.ACCESS_TOKEN, accessToken)?.apply()
        }

        fun getAccessToken(): String? {
            return SharedPreferenceUtil.readFromSharedPreferences(StaticKey.ACCESS_TOKEN)
        }

    }
}