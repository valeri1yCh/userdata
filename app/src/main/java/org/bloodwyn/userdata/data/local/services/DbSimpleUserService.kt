package org.bloodwyn.userdata.data.local.services

import androidx.room.Dao
import io.reactivex.rxjava3.core.Observable
import org.bloodwyn.userdata.data.local.DbUser

@Dao
interface DbSimpleUserService {

    fun findAllUsers(): Observable<DbUser>
}