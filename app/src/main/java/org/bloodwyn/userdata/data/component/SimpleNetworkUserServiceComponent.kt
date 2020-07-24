package org.bloodwyn.userdata.data.component

import dagger.Component
import org.bloodwyn.userdata.data.dependensys.SimpleNetworkUserServiceImplModule
import org.bloodwyn.userdata.data.remote.services.SimpleNetworkUserServiceImpl

@Component(modules = [SimpleNetworkUserServiceImplModule::class])
interface SimpleNetworkUserServiceComponent {

    fun inject(networkUserService: SimpleNetworkUserServiceImpl)
}