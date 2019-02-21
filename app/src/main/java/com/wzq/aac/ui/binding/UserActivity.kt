package com.wzq.aac.ui.binding

import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.wzq.aac.R
import com.wzq.aac.databinding.ActivityUserBinding
import com.wzq.aac.model.User
import com.wzq.aac.ui.main.TopicViewModel

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind: ActivityUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        val topicVM = ViewModelProviders.of(this).get(TopicViewModel::class.java)

        bind.userInfo = User(1, "ss", 2, 3, "dsd")
        bind.lifecycleOwner = this

    }
}