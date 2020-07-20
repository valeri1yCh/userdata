package org.bloodwyn.userdata.view.user

import androidx.recyclerview.widget.RecyclerView
import org.bloodwyn.userdata.data.User
import org.bloodwyn.userdata.databinding.UserBinding

class UserViewHolder(private val binding: UserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.userViewModel?.user?.set(user)
    }
}