package org.bloodwyn.userdata.data.local.services

import io.reactivex.rxjava3.core.Observable
import org.bloodwyn.userdata.data.local.DbUser

class DbSimpleUserServiceImpl : UserDao {

    override fun findAllUsers(): Observable<DbUser> {

    }
}