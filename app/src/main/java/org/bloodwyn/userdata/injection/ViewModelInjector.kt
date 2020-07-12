package org.bloodwyn.userdata.injection

import androidx.fragment.app.Fragment

interface ViewModelInjector {

    fun inject(fragment: Fragment)
}