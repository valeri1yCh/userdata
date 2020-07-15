package org.bloodwyn.userdata.data

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface UserRepository {

    fun getUsers() : Single<List<User>>

    fun getUserInfo(userId: String): Maybe<User>
}