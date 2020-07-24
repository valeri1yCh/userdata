package org.bloodwyn.userdata.data.local

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME = "userinfo_app_database"

/**
 * The singleton that holds the [UserInfoAppDatabase] instance
 *
 */
object DbHolder {

    @Volatile
    lateinit var appDatabase: UserInfoAppDatabase

    fun createDatabase(ctx: Context) {
        if (!this::appDatabase.isInitialized) {
            synchronized(this) {
                if (!this::appDatabase.isInitialized) {
                    val db = Room.databaseBuilder(
                        ctx.applicationContext,
                        UserInfoAppDatabase::class.java,
                        DATABASE_NAME)
                        .build()
                    appDatabase = db
                }
            }
        }
    }
}