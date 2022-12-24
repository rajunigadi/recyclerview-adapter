package com.raju.generic.list.adapter.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.raju.generic.list.adapter.base.BaseAdapter
import com.raju.generic.list.adapter.data.DashboardHeader
import com.raju.generic.list.adapter.data.DashboardItem
import com.raju.generic.list.adapter.data.ListItem
import com.raju.generic.list.adapter.databinding.LayoutDashboardItemBinding
import com.raju.generic.list.adapter.databinding.LayoutHeaderItemBinding

class DashboardAdapter(private val listener: (ListItem, View) -> Unit) : BaseAdapter<ListItem>() {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return when (viewType) {
            VIEW_HEADER -> LayoutHeaderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            else -> LayoutDashboardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DashboardHeader -> VIEW_HEADER
            else -> VIEW_DASHBOARD
        }
    }

    override fun bind(binding: ViewBinding, listItem: ListItem) {
        when (binding) {
            is LayoutDashboardItemBinding -> {
                val item = listItem as DashboardItem
                binding.tvTitle.text = item.title
                binding.tvMessage.text = item.message
                binding.root.setOnClickListener {
                    listener.invoke(item, it)
                }
            }
            is LayoutHeaderItemBinding -> {
                val item = listItem as DashboardHeader
                binding.tvTitle.text = item.header
            }
            else -> Log.d("DashboardAdapter", "Unknown view binding")
        }
    }

    companion object {
        const val VIEW_HEADER = 1
        const val VIEW_DASHBOARD = 2
    }
}