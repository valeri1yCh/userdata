package org.bloodwyn.userdata.data.local.services

import io.reactivex.rxjava3.core.Observable
import org.bloodwyn.userdata.data.local.DbHolder
import org.bloodwyn.userdata.data.local.DbUser

class DbSimpleUserServiceImpl : UserDao {

    private val dao = DbHolder.getDatabase().userDao()

    override fun findAllUsers(): Observable<List<DbUser>> {
        return dao.findAllUsers()
    }
}