package org.bloodwyn.userdata.data

import org.bloodwyn.userdata.data.remote.services.SimpleNetworkUserServiceImpl
import java.util.*

class UserRepository : UserService {

    private val userService: SimpleNetworkUserServiceImpl

    init {
        userService =
            SimpleNetworkUserServiceImpl()
    }

    override fun getUsers(): List<User> {
        return Collections.emptyList()
    }
}