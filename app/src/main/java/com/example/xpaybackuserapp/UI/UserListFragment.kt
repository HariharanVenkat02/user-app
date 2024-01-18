package com.example.xpaybackuserapp.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xpaybackuserapp.Network.ApiService
import com.example.xpaybackuserapp.Repositary.UserRepositary
import com.example.xpaybackuserapp.Utils.ClickListerner
import com.example.xpaybackuserapp.Utils.ViewModelFactory
import com.example.xpaybackuserapp.ViewModel.UserListViewModel
import com.example.xpaybackuserapp.databinding.FragmentUserListBinding

class UserListFragment : Fragment(), ClickListerner {
    private lateinit var userDetailAdapter: UserDetailAdapter
    private lateinit var binding: FragmentUserListBinding
    private lateinit var viewmodel: UserListViewModel
    private var limit: Int = 20
    private var skip: Int = 0
    private var totalRecord: Int = 0
    private var isloading :Boolean =false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initView() {
        binding.listRecycler.layoutManager = LinearLayoutManager(requireContext())
        userDetailAdapter = UserDetailAdapter(listOf(), this)

    }

    private fun loadMore() {
        skip += 20
        viewmodel.fetchUsers(limit, skip)
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.listRecycler.adapter = userDetailAdapter
        val repository = UserRepositary(ApiService())
        viewmodel =
            ViewModelProvider(this, ViewModelFactory(repository)).get(UserListViewModel::class.java)
        viewmodel.userList.observe(viewLifecycleOwner, Observer { userResponse ->
            binding.listRecycler.also {
                userDetailAdapter.setUserList(userResponse.users)
                totalRecord = userResponse.total
                isloading=false
            }
        })

        fetchData()
        setPagination()
    }

    private fun setPagination() {
        binding.listRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        if (userDetailAdapter.itemCount < totalRecord) {
                            if (!isloading) {
                                loadMore()
                            }
                        }
                    }
                }
            }
        })

    }

    private fun fetchData() {
        isloading =true
        viewmodel.fetchUsers(limit, skip)
    }


    override fun onItemClick(id: Int?) {
        id?.let {
            val intent = Intent(requireContext(), UserDeatilsActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
    }
}