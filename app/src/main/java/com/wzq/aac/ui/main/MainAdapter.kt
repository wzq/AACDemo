package com.wzq.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wzq.aac.R
import com.wzq.aac.model.News

class MainAdapter(val data: List<News>): RecyclerView.Adapter<MainAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainAdapter.Holder, position: Int) {
        val itemData = data[position]
        holder.itemView.tag = itemData.id
        holder.title.text = itemData.title
        if (itemData.images.isNotEmpty())
        Glide.with(holder.itemView.context).load(itemData.images[0]).into(holder.img)
    }

    class Holder(root: View): RecyclerView.ViewHolder(root){
        val img = root.findViewById<ImageView>(R.id.main_img)
        val title = root.findViewById<TextView>(R.id.main_title)

        init {
            root.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainFragment_to_detailFragment, Bundle().apply {
                    this.putInt("newsId", it.tag as? Int ?:0)
                })
            }
        }
    }
}