package com.example.xpaybackuserapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xpaybackuserapp.Data.UserDetailsModel
import com.example.xpaybackuserapp.Data.UserResponse
import com.example.xpaybackuserapp.Repositary.UserRepositary
import kotlinx.coroutines.launch

class UserListViewModel(private val repository: UserRepositary) : ViewModel() {

    private val _userList = MutableLiveData<UserResponse>()
    val userList: LiveData<UserResponse> get() = _userList

    private val _specificUserDetails = MutableLiveData<UserDetailsModel>()
    val specificUserList: LiveData<UserDetailsModel> get() = _specificUserDetails

    fun fetchUsers(limit: Int, skip: Int) {
        viewModelScope.launch {
            _userList.value = repository.getUsersList(limit, skip)
        }
    }

    fun fetchUserDetails(userId: Int) {
        viewModelScope.launch {
            _specificUserDetails.value = repository.getUserDetails(userId)
        }
    }
}