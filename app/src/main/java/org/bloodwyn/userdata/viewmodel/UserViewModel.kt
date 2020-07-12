package org.bloodwyn.userdata.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import org.bloodwyn.userdata.data.User

class UserViewModel : ViewModel() {

    var user = ObservableField<User>()
}