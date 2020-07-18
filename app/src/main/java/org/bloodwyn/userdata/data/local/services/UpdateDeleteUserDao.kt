package org.bloodwyn.userdata.data.local.services

import io.reactivex.Completable

interface UpdateDeleteUserDao {

    fun removeAll(): Completable

    fun remove(userId: String): Completable
}