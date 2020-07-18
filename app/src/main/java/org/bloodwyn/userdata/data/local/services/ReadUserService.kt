package org.bloodwyn.userdata.data.local.services

import io.reactivex.Single
import org.bloodwyn.userdata.data.local.DbHolder
import org.bloodwyn.userdata.data.local.DbUser

class ReadUserService(
    private val dao: ReadUserDao
) : ReadUserDao {

    override fun findAllUsers(): Single<List<DbUser>> {
        return dao.findAllUsers()
    }
}