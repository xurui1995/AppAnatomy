package xur.com.appanatomy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.apps_list_fragment.*
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

        loadAppsData()
    }

    private fun loadAppsData() {
        val appList = ArrayList<AppInfo>()
        (0 .. 30).mapTo(appList) { AppInfo("package_name_" + it) }
        apps_list.adapter = AppsAdapter(appList)
    }


}