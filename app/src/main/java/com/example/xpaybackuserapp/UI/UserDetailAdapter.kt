package com.example.xpaybackuserapp.UI

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xpaybackuserapp.Data.UserDetailsModel
import com.example.xpaybackuserapp.R
import com.example.xpaybackuserapp.Utils.ClickListerner
import com.squareup.picasso.Picasso


class UserDetailAdapter(
    private var userList: List<UserDetailsModel>,
    val listerner: ClickListerner
) : RecyclerView.Adapter<UserDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = userList[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(users: List<UserDetailsModel>) {
        userList += users
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: UserDetailsModel) {
            val image :ImageView = itemView.findViewById(R.id.image)
            val name: TextView = itemView.findViewById(R.id.name)
            val email: TextView = itemView.findViewById(R.id.email)
            val phone: TextView = itemView.findViewById(R.id.phone)

            Picasso.get().load(user.image).into(image)
            name.text = user.firstName
            email.text = user.email
            phone.text = user.phone?.replace("\\s".toRegex(),"")


            itemView.setOnClickListener {
                listerner.onItemClick(user.id)
            }
        }
    }
}

