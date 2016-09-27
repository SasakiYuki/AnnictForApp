package jp.hunza.blog.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by yuki.sasaki.a on 2016/08/16.
 */
object PrefUtils {
    private var pref: SharedPreferences? = null
    private fun getEditor(context: Context) = getPref(context).edit()
    private fun getPref(context: Context) = (pref ?: PreferenceManager.getDefaultSharedPreferences(context))
    fun put(context: Context, name: String, value: String) = getEditor(context).putString(name, value).apply()
    fun put(context: Context, name: String, value: Int) = getEditor(context).putInt(name, value).apply()
    fun put(context:Context,name:String,value:Boolean) = getEditor(context).putBoolean(name,value).apply()
    operator fun get(context: Context, name: String, defaultValue: String = "") = getPref(context).getString(name, defaultValue)
    operator fun get(context: Context, name: String, defaultValue: Int) = getPref(context).getInt(name, defaultValue)
    operator fun get(context: Context,name: String,defaultValue: Boolean) = getPref(context).getBoolean(name,defaultValue)
}