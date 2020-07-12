package org.bloodwyn.userdata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.bloodwyn.userdata.R
import org.bloodwyn.userdata.injection.DefViewModelInjector
import org.bloodwyn.userdata.view.user.UsersFragment

class HostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)
        val fragment = UsersFragment()
        addFragment(fragment, R.id.container, "user_list")
    }
}
