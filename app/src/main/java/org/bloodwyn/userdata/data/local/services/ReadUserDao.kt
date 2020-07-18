package org.bloodwyn.userdata.data.local.services

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Maybe
import io.reactivex.Single
import org.bloodwyn.userdata.data.local.DbUser

/**
 * A room dao interface, provide methods for read [DbUser]
 * from db
 */
@Dao
interface ReadUserDao {

    @Query("SELECT * FROM user")
    fun findAllUsers(): Single<List<DbUser>>

    /**
     * Find [DbUser] ib db by [DbUser.Id]
     */
    @Query("SELECT * FROM user WHERE name = :idName AND value = :idValue")
    fun findById(idName: String, idValue: String): Maybe<DbUser>
}