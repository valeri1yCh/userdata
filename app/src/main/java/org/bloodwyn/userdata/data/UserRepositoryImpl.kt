package org.bloodwyn.userdata.data

import io.reactivex.Maybe
import io.reactivex.Single
import org.bloodwyn.userdata.data.remote.UserTransformer
import org.bloodwyn.userdata.data.remote.services.SimpleNetworkUserServiceImpl
import java.util.*
import kotlin.collections.ArrayList

class UserRepositoryImpl : UserRepository {

    private val userService: SimpleNetworkUserServiceImpl =
        SimpleNetworkUserServiceImpl()


    override fun getUsers(): Single<List<User>> {
        val transformer = UserTransformer()
        return userService.getUsers(10)
            .map { response ->
                val users = ArrayList<User>()
                response.body()?.let {
                    for (i in it.results) {
                        users.add(transformer.transform(i))
                    }
                }
                users
            }
    }

    override fun getUserInfo(userId: String): Maybe<User> {
        TODO("Not yet implemented")
    }
}