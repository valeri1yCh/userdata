package org.bloodwyn.userdata.data.component

import dagger.Component
import org.bloodwyn.userdata.data.dependensys.ReadUserDaoModule
import org.bloodwyn.userdata.data.local.services.ReadUserService

@Component(modules = [ReadUserDaoModule::class])
interface ReadUserServiceComponent  {

    fun inject(readUserService: ReadUserService)
}