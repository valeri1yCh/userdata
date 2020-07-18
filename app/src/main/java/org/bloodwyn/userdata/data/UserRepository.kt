package org.bloodwyn.userdata.data

import io.reactivex.Maybe
import io.reactivex.Single


interface UserRepository {

    fun getUsers() : Single<List<User>>

    fun getUserInfo(userId: String): Maybe<User>
}