package org.bloodwyn.userdata.utill

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.bloodwyn.userdata.application.UserDataApplication
import org.bloodwyn.userdata.viewmodel.DefaultViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelProvider.Factory {
    val repository = (requireContext().applicationContext as UserDataApplication).repository

    return DefaultViewModelFactory(repository)
}