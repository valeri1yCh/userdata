package org.bloodwyn.userdata.application

import android.app.Application
import org.bloodwyn.userdata.data.ServiceLocator
import org.bloodwyn.userdata.data.UserRepository
import org.bloodwyn.userdata.data.UserRepositoryImpl

class UserDataApplication  : Application() {


    val repository: UserRepository
        get() = ServiceLocator.provideRepository()


}