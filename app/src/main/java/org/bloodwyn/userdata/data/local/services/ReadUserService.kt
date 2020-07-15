package org.bloodwyn.userdata.data.local.services

import io.reactivex.rxjava3.core.Observable
import org.bloodwyn.userdata.data.local.DbHolder
import org.bloodwyn.userdata.data.local.DbUser

class ReadUserService(
    private val dao: ReadUserDao = DbHolder.getDatabase().userDao()
) : ReadUserDao {

    override fun findAllUsers(): Observable<List<DbUser>> {
        return dao.findAllUsers()
    }
}