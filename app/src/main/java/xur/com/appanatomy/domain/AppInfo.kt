package xur.com.appanatomy.domain

import android.graphics.drawable.Drawable

/**
 * Created by xur on 2018/3/29.
 */
data class AppInfo(val packageName: String = "",
                   val appName: String = "",
                   val versionName: String = "",
                   val versionCode: String = "",
                   val appIcon: Drawable,
                   val appPath: String = "")