package org.bloodwyn.userdata.application

import android.app.Application
import org.bloodwyn.userdata.data.ServiceLocator
import org.bloodwyn.userdata.data.UserRepository
import org.bloodwyn.userdata.data.local.DbHolder

/**
 * Contains the logic that should init with bootstrap of app
 */
class UserDataApplication : Application() {

    val repository: UserRepository
        get() = ServiceLocator.provideRepository()

    override fun onCreate() {
        DbHolder.createDatabase(this)
        super.onCreate()
    }
}