package com.wzq.aac.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wzq.aac.database.AppDatabase
import com.wzq.aac.database.OrderRepository

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
//        val binding = FragmentMainBinding.inflate(inflater, container, false)
//        return binding.root
        return View(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = OrderViewModelFactory(OrderRepository.getInstance(AppDatabase.getInstance(context!!).getOrderDao()))
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.getOrders().observe(viewLifecycleOwner, Observer {
            if (it!=null)
            showMsg("${it.size}")
        })

    }

    fun showMsg(msg: String) {
        println("$msg---record")
    }

}
