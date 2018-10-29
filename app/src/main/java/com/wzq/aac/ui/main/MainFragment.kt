package com.wzq.aac.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wzq.aac.database.AppDatabase
import com.wzq.aac.database.OrderRepository
import com.wzq.aac.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)


        val factory = OrderViewModelFactory(OrderRepository.getInstance(AppDatabase.getInstance(requireContext()).getOrderDao()))
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.orders.observe(viewLifecycleOwner, Observer {
            showMsg("${it.size}")
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Thread {
            viewModel.add()
            println("removed")
        }.start()

    }

    fun showMsg(msg: String) {
        println("$msg---record")
    }

}
