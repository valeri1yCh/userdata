package org.bloodwyn.userdata.data.local.services

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable
import org.bloodwyn.userdata.data.local.DbUser

/**
 * A room dao interface, provide methods for read [DbUser]
 * from db
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun findAllUsers(): Observable<List<DbUser>>
}