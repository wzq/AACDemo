package com.wzq.aac.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.wzq.aac.R
import com.wzq.aac.utils.getFactory
import com.wzq.aac.model.News

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private val listData = arrayListOf<News>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val listView = root.findViewById<RecyclerView>(R.id.list_view)
        val loading = root.findViewById<View>(R.id.loading)
        listView.adapter = MainAdapter(listData)

        viewModel = ViewModelProviders.of(this, getFactory(requireContext())).get(MainViewModel::class.java)

        viewModel.news.observe(viewLifecycleOwner, Observer {
            if (it!=null && it.stories.isNotEmpty()){
                loading.visibility = View.GONE
                listData.clear()
                listData.addAll(it.stories)
                listView.adapter?.notifyDataSetChanged()
            } else {
                loading.visibility = View.VISIBLE
            }

        })

        viewModel.dbNews.observe(viewLifecycleOwner, Observer {
            Log.i("aac_log", "db news list size => ${it?.size}")
            Toast.makeText(requireContext(), "db news list size => ${it?.size}", Toast.LENGTH_LONG).show()
        })

        return root
    }

}
