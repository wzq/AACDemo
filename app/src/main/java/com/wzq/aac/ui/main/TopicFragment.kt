package com.wzq.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wzq.aac.R
import com.wzq.aac.model.User

class TopicFragment : Fragment() {

    val data = arrayListOf<User>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_topic, container, false)
        val listView = root.findViewById<RecyclerView>(R.id.topic_list)!!
        listView.layoutManager = LinearLayoutManager(activity)
        listView.adapter = TopicAdapter(data)

        val vm = ViewModelProviders.of(this).get(TopicViewModel::class.java)
        vm.getAllUser().observe(viewLifecycleOwner, Observer {
            data.clear()
            data.addAll(it.data)
            (listView.adapter as TopicAdapter).notifyDataSetChanged()
        })

        return root
    }
}