package org.bloodwyn.userdata.data

import androidx.annotation.VisibleForTesting

object ServiceLocator  {

    @Volatile
    var repository: UserRepository? = null
        @VisibleForTesting set

    fun provideRepository(): UserRepository {
        synchronized(this) {
            return repository ?: repository ?: UserRepositoryImpl()
        }
    }
}