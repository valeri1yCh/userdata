package org.bloodwyn.userdata.data.local.services

import io.reactivex.Maybe
import io.reactivex.Single
import org.bloodwyn.userdata.data.local.DbUser

class ReadUserService(
    private val dao: ReadUserDao
) : ReadUserDao {

    override fun findAllUsers(): Single<List<DbUser>> {
        return dao.findAllUsers()
    }

    override fun findById(idName: String, idValue: String): Maybe<DbUser> {
        TODO("Not yet implemented")
    }
}