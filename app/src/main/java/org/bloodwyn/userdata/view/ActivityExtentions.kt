package org.bloodwyn.userdata.view

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.addFragment(fragment: Fragment, containerId: Int, fragmentId: String) {
    val fm = supportFragmentManager
    val f = fm.findFragmentById(containerId)
    if (f === null) {
        fm.beginTransaction()
            .add(containerId, fragment, fragmentId)
            .commitNow()
    }
}