package org.bloodwyn.userdata.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import org.bloodwyn.userdata.data.local.services.UserDao

@Database(entities = arrayOf(DbUser::class), version = 1)
abstract class UserInfoAppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}