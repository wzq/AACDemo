package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.model.UserResult
import com.wzq.aac.utils.Linker

class TopicViewModel: ViewModel() {

    fun getAllUser(): LiveData<UserResult> {
        return Linker.userApi.allUser()
    }

}
