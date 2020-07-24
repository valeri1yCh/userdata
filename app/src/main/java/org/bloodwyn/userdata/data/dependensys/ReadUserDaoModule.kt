package org.bloodwyn.userdata.data.dependensys

import dagger.Module
import dagger.Provides
import org.bloodwyn.userdata.data.local.DbHolder
import org.bloodwyn.userdata.data.local.services.ReadUserDao

@Module
class ReadUserDaoModule {

    @Provides
    fun getReadUserDao(): ReadUserDao {
        return DbHolder.appDatabase.userDao()
    }
}