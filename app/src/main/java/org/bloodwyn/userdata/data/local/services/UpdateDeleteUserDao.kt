package org.bloodwyn.userdata.data.local.services

import androidx.room.Dao
import io.reactivex.Completable

@Dao
interface UpdateDeleteUserDao {

    fun removeAll(): Completable

    fun remove(userId: String): Completable
}