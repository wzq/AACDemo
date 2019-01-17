package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.model.UserResult
import com.wzq.aac.utils.Linker
import com.wzq.aac.utils.TestRes

class TopicViewModel: ViewModel() {

    fun getAllUser(): LiveData<TestRes<UserResult>> {
        return Linker.userApi.allUser()
    }

}
