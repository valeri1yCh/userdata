package org.bloodwyn.userdata.data.local.services

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable
import org.bloodwyn.userdata.data.local.DbUser

@Dao
interface UserDao {


    @Query("SELECT * FROm user")
    fun findAllUsers(): Observable<DbUser>
}