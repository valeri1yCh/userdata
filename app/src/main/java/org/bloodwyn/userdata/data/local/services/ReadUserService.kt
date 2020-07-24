package org.bloodwyn.userdata.data.local.services

import io.reactivex.Maybe
import io.reactivex.Single
import org.bloodwyn.userdata.application.UserDataApplication
import org.bloodwyn.userdata.data.local.DbUser
import javax.inject.Inject

class ReadUserService @Inject constructor(private val dao: ReadUserDao): ReadUserDao {

    init {
        UserDataApplication.readUserServiceComponent.inject(this)
    }

    override fun findAllUsers(): Single<List<DbUser>> {
        return dao.findAllUsers()
    }

    override fun findById(idName: String, idValue: String): Maybe<DbUser> {
        return dao.findById(idName, idValue)
    }
}