package com.wzq.aac.ui.main

import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.wzq.aac.R
import com.wzq.aac.utils.getDetailVM

class DetailFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_detail, container, false)

        val web = root.findViewById<WebView>(R.id.detail_web)
        val image = root.findViewById<ImageView>(R.id.detail_img).also {
            it.setOnClickListener { findNavController().navigate(R.id.action_detailFragment_to_topicFragment) }
        }
        val head = root.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)

        val args = arguments?.getInt("newsId") ?: 0

        val viewModel = ViewModelProviders.of(this, getDetailVM(requireContext())).get(DetailViewModel::class.java)

        viewModel.getDetail(args).observe(viewLifecycleOwner, Observer {
            head.title  = it.contents.title

            Glide.with(requireContext()).load(it.contents.image).into(image)
            val css = it.contents.css[0]

            val linkCss = "<link rel=\"stylesheet\" href=$css type=\"text/css\">"

            val body = ("<html><header>" + linkCss + "</header>" + it.contents.body
                    + "</body></html>")

            web.loadDataWithBaseURL(css, body, "text/html", "UTF-8", null)
        })

        setHasOptionsMenu(true)
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_detail, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        findNavController().navigate(R.id.action_detailFragment_to_topicFragment)
        return super.onOptionsItemSelected(item)
    }
}