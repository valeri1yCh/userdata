package org.bloodwyn.userdata.data.local.services

import androidx.room.Dao
import androidx.room.Insert
import io.reactivex.Completable
import org.bloodwyn.userdata.data.local.DbUser

/**
 * The dao interface provide methods for write, update and delete
 * [DbUser] into db
 */
@Dao
interface WriteUserDao {

    @Insert
    fun insertAll(users: List<DbUser>): Completable
}