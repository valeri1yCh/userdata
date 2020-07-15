package org.bloodwyn.userdata.data

import org.bloodwyn.userdata.data.remote.services.SimpleNetworkUserServiceImpl
import org.junit.Before
import org.junit.Test

class UserServiceImplTest {

    private lateinit var userService: SimpleNetworkUserServiceImpl

    @Before
    fun setUp() {
        userService =
            SimpleNetworkUserServiceImpl()
    }

    @Test
    fun getUsersTest() {
        val response = userService.getUsers(10)
            .blockingGet()
        println(response.code())
        println(response.body())


    }

}