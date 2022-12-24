package com.raju.generic.list.adapter.ui.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import coil.load
import com.raju.generic.list.adapter.base.BaseAdapter
import com.raju.generic.list.adapter.data.User
import com.raju.generic.list.adapter.databinding.LayoutHomeItemBinding

@SuppressLint("ResourceType")
class HomeAdapter(private val listener: (User, View) -> Unit) : BaseAdapter<User>() {

    private val imageUrl =
        "https://png.pngtree.com/png-vector/20191101/ourmid/pngtree-cartoon-color-simple-male-avatar-png-image_1934459.jpg"

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return LayoutHomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bind(binding: ViewBinding, item: User) {
        when (binding) {
            is LayoutHomeItemBinding -> {
                binding.tvName.text = item.name
                binding.tvEmail.text = item.email
                binding.ivProfile.load(imageUrl)
                binding.root.setOnClickListener {
                    listener.invoke(item, it)
                }
            }
            else -> Log.d("HomeAdapter", "Unknown view binding")
        }
    }
}