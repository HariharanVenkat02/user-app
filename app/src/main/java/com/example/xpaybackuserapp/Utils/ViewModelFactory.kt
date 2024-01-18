package com.example.xpaybackuserapp.Utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xpaybackuserapp.Repositary.UserRepositary
import com.example.xpaybackuserapp.ViewModel.UserListViewModel

class ViewModelFactory(private val repository: UserRepositary) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(repository) as T
    }
}