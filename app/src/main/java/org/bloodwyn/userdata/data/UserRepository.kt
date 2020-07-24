package org.bloodwyn.userdata.data

import io.reactivex.Maybe
import io.reactivex.Single


interface UserRepository {

    fun downloadNewUsers(): Single<List<User>>

    fun getUsers(count: Int): Single<List<User>>

    fun getUserInfo(id: User.Id): Maybe<User>
}