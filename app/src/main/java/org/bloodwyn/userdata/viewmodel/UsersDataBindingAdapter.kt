package org.bloodwyn.userdata.viewmodel

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.bloodwyn.userdata.data.User
import org.bloodwyn.userdata.view.user.UserAdapter


@BindingAdapter("app:items")
fun setData(usersView: RecyclerView, data: List<User>?) {
    data?.let {
        val adapter = (usersView.adapter as UserAdapter)
        adapter.setUsers(it)
        adapter.notifyDataSetChanged()
    }
}