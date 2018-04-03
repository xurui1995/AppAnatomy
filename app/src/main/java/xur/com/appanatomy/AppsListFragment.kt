package xur.com.appanatomy

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.apps_list_fragment.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import xur.com.appanatomy.adapter.AppsAdapter
import xur.com.appanatomy.domain.AppInfo
import xur.com.appanatomy.extensions.inflate



/**
 * Created by xur on 2018/3/27.
 */
class AppsListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.apps_list_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        apps_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }

        getData()
    }

    private fun loadAppsData(appList: ArrayList<AppInfo>) {
        apps_list.adapter = AppsAdapter(appList)
    }

    private fun getData() {
        doAsync {
            val appList = ArrayList<AppInfo>()
            try {
                val packageManager = activity.packageManager
                val installedList = packageManager.getInstalledPackages(0)
                installedList.mapTo(appList) {
                    AppInfo(it.packageName,
                            it.applicationInfo.loadLabel(packageManager).toString(),
                            it.versionName,
                            it.versionCode.toString(),
                            it.applicationInfo.loadIcon(packageManager))
                }
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            uiThread {
                loadAppsData(appList)
            }
        }
    }
}