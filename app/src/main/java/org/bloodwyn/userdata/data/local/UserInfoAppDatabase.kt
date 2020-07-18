package org.bloodwyn.userdata.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import org.bloodwyn.userdata.data.local.services.ReadUserDao
import org.bloodwyn.userdata.data.local.services.WriteUserDao

@Database(entities = [DbUser::class], version = 1)
@TypeConverters(DbUserConverter::class)
abstract class UserInfoAppDatabase : RoomDatabase() {

    abstract fun userDao(): ReadUserDao

    abstract fun writeUserDao(): WriteUserDao
}