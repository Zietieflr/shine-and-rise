package com.projectmod5.shineandrise.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projectmod5.shineandrise.viewModels.AlarmItem
import kotlinx.android.synthetic.main.alarm_item.view.*

internal class MyAdapter(private val arrayList: ArrayList<AlarmItem>,
                         private val context: Context,
                         private val layout: Int) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(items: AlarmItem) {
            itemView.tvName.text = items.name
            itemView.tvNumber.text = items.number
        }
    }
}