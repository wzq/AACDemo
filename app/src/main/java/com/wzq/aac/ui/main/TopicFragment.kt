package com.wzq.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wzq.aac.R

class TopicFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_topic, container, false)

        val vm = ViewModelProviders.of(this).get(TopicViewModel::class.java)
        vm.getAllUser().observe(viewLifecycleOwner, Observer{
            println(it.toString())
        })

        return root
    }
}