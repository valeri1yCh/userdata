package org.bloodwyn.userdata.injection

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.bloodwyn.userdata.view.user.UsersFragment
import org.bloodwyn.userdata.viewmodel.UsersViewModel

class DefViewModelInjector : ViewModelInjector {

    override fun inject(fragment: Fragment) {
        when (fragment::class) {
            UsersFragment::class -> {
                val app = fragment.activity?.application
                requireNotNull(app)
                val usersViewModel = ViewModelProvider.AndroidViewModelFactory(app)
                    .create(UsersViewModel::class.java)
            }
        }
    }
}