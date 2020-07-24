package org.bloodwyn.userdata.data

import androidx.annotation.VisibleForTesting
import org.bloodwyn.userdata.data.local.DbHolder
import org.bloodwyn.userdata.data.local.services.ReadUserService
import org.bloodwyn.userdata.data.remote.services.NetworkSimpleUserService
import org.bloodwyn.userdata.data.remote.services.SimpleNetworkUserServiceImpl

object ServiceLocator  {

    @Volatile
    var repository: UserRepository? = null
        @VisibleForTesting set

    fun provideRepository(): UserRepository {
        synchronized(this) {
            return repository ?: repository ?: UserRepositoryImpl(
                ReadUserService(),
                SimpleNetworkUserServiceImpl())
        }
    }
}