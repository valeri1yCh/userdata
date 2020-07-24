package org.bloodwyn.userdata.application

import android.app.Application
import org.bloodwyn.userdata.data.ServiceLocator
import org.bloodwyn.userdata.data.UserRepository
import org.bloodwyn.userdata.data.component.DaggerReadUserServiceComponent
import org.bloodwyn.userdata.data.component.DaggerSimpleNetworkUserServiceComponent
import org.bloodwyn.userdata.data.component.ReadUserServiceComponent
import org.bloodwyn.userdata.data.component.SimpleNetworkUserServiceComponent
import org.bloodwyn.userdata.data.dependensys.ReadUserDaoModule
import org.bloodwyn.userdata.data.dependensys.SimpleNetworkUserServiceImplModule
import org.bloodwyn.userdata.data.local.DbHolder

/**
 * Contains the logic that should init with bootstrap of app
 */
class UserDataApplication : Application() {

    companion object {
        lateinit var readUserServiceComponent: ReadUserServiceComponent
        lateinit var simpleNetworkUserServiceComponent : SimpleNetworkUserServiceComponent
    }

    val repository: UserRepository
        get() = ServiceLocator.provideRepository()

    override fun onCreate() {
        DbHolder.createDatabase(this)
        super.onCreate()
        readUserServiceComponent =
            DaggerReadUserServiceComponent.builder()
            .readUserDaoModule(ReadUserDaoModule())
            .build()
        simpleNetworkUserServiceComponent =
            DaggerSimpleNetworkUserServiceComponent.builder()
            .simpleNetworkUserServiceImplModule(SimpleNetworkUserServiceImplModule())
            .build()
    }
}