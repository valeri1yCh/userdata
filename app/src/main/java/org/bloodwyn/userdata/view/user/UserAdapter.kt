package org.bloodwyn.userdata.view.user

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.bloodwyn.userdata.R
import org.bloodwyn.userdata.data.User
import org.bloodwyn.userdata.databinding.UserBinding

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private lateinit var users: List<User>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding =
            DataBindingUtil.inflate<UserBinding>(inflater, R.layout.user, parent, false)

        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun setUsers(users: List<User>) {
        this.users = users
    }
}