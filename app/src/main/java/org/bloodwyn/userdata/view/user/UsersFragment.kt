package org.bloodwyn.userdata.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.bloodwyn.userdata.R
import org.bloodwyn.userdata.data.UserRepositoryImpl
import org.bloodwyn.userdata.databinding.UserListBinding
import org.bloodwyn.userdata.utill.getViewModelFactory
import org.bloodwyn.userdata.viewmodel.DefaultViewModelFactory
import org.bloodwyn.userdata.viewmodel.UsersViewModel


/**
 * The fragment is responsible for display list of users
 *
 */
class UsersFragment : Fragment() {

    private val viewModel by viewModels<UsersViewModel> { getViewModelFactory() }

    private lateinit var binding: UserListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<UserListBinding>(inflater, R.layout.user_list,  container, false)

        val adapter = UserAdapter()
        binding.users.adapter = adapter
        binding.users.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.usersViewModel = viewModel

        return binding.root
    }

    override fun onStart() {
        viewModel.start()
        super.onStart()
    }
}