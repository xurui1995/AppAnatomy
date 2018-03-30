package xur.com.appanatomy.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.app_item.view.*
import xur.com.appanatomy.R
import xur.com.appanatomy.domain.AppInfo
import xur.com.appanatomy.extensions.inflate

/**
 * Created by xur on 2018/3/27.
 */
class AppsAdapter(val appList: List<AppInfo>): RecyclerView.Adapter<AppsAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindApp(appList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(parent.inflate(R.layout.app_item))

    override fun getItemCount(): Int = appList.size


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindApp(appInfo: AppInfo) {
            itemView.package_name.text = appInfo.packageName
        }
    }
}