package org.bloodwyn.userdata.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.bloodwyn.userdata.data.UserRepository
import org.bloodwyn.userdata.data.UserRepositoryImpl
import java.lang.UnsupportedOperationException

@Suppress("Unchecked_Cast")
class DefaultViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            UsersViewModel::class.java -> UsersViewModel(userRepository)

            else -> throw UnsupportedOperationException("Your ViewModel class is not support's")

        } as T
    }
}
