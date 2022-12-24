package com.raju.generic.list.adapter.base

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T : Any> : ListAdapter<T, BaseViewHolder>(BaseItemCallback<T>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = createBinding(parent, viewType)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (position < itemCount) {
            bind(holder.binding, getItem(position))
        }
    }

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int): ViewBinding

    protected abstract fun bind(binding: ViewBinding, item: T)
}