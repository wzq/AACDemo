package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.model.NewsResult
import com.wzq.aac.model.User
import com.wzq.aac.model.UserResult
import com.wzq.aac.utils.Linker

class TopicViewModel: ViewModel() {

    fun getAllUser(): LiveData<UserResult> {
        return Linker.userApi.allUser()
    }

    val user = MediatorLiveData<User>()

    fun getUser(id: Int){
        user.addSource(Linker.userApi.findUser(id), user::setValue)
    }

}
