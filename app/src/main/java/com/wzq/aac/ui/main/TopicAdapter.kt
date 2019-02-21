package com.wzq.aac.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wzq.aac.R
import com.wzq.aac.model.User

class TopicAdapter(val data: List<User>) : RecyclerView.Adapter<TopicAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.topic_item, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        data[position].let {
            holder.t1.text = it.toString()
        }
    }

    inner class Holder(root: View) : RecyclerView.ViewHolder(root) {
        val t1 = root.findViewById<TextView>(R.id.topic_item_t1)

        init {
            root.setOnClickListener {
                
            }
        }
    }
}