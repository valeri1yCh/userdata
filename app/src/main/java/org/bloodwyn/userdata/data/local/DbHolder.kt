package org.bloodwyn.userdata.data.local

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME = "userinfo_app_database"

object DbHolder {

    private var appDatabase: UserInfoAppDatabase? = null

    fun getDatabase(): UserInfoAppDatabase {

        return requireNotNull(appDatabase) { "Db has not been created"}
    }

    fun createDatabase(ctx: Context) {
        val db = Room.databaseBuilder(
                ctx.applicationContext,
                UserInfoAppDatabase::class.java,
                DATABASE_NAME)
            .build()
        appDatabase = db
    }
}