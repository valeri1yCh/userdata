package org.bloodwyn.userdata.data.local

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME = "userinfo_app_database"

object DbHolder {

    private var appDatabase: UserInfoAppDatabase? = null

    fun getDatabase(appContext: Context): UserInfoAppDatabase {
        if (appDatabase == null) {
            synchronized(this) {
                if (appDatabase == null) {
                    val db = Room.databaseBuilder(
                        appContext,
                        UserInfoAppDatabase::class.java,
                        DATABASE_NAME).build()
                    appDatabase = db
                }
            }
        }

        return appDatabase!!
    }
}