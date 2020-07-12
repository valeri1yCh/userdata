package org.bloodwyn.userdata.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import org.bloodwyn.userdata.view.user.UsersFragment

class TestFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {

            UsersFragment::class.simpleName -> UsersFragment()

            else -> return super.instantiate(classLoader, className)
        }
    }
}