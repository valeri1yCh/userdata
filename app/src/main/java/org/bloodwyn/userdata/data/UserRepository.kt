package org.bloodwyn.userdata.data

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

interface UserRepository {

    fun getUsers() : Observable<List<User>>

    fun getUserInfo(userId: String): Maybe<User>
}