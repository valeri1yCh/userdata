package org.bloodwyn.userdata.data

import io.reactivex.Maybe
import io.reactivex.Single
import org.bloodwyn.userdata.data.local.DbUserTransformer
import org.bloodwyn.userdata.data.local.services.ReadUserService
import org.bloodwyn.userdata.data.remote.UserTransformer
import org.bloodwyn.userdata.data.remote.services.NetworkSimpleUserService
import org.bloodwyn.userdata.data.remote.services.SimpleNetworkUserServiceImpl
import kotlin.collections.ArrayList

class UserRepositoryImpl(
    private val localUserService: ReadUserService,
    private val networkUserService: NetworkSimpleUserService
) : UserRepository {

    override fun downloadNewUsers(): Single<List<User>> {
        val transformer = UserTransformer()
        return networkUserService.getUsers(10)
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

    override fun getUserInfo(id: User.Id): Maybe<User> {
        return localUserService.findById(id.name, id.value)
            .map {dbuser ->
                DbUserTransformer().transform(dbuser)
            }
    }

    override fun getUsers(count: Int): Single<List<User>> {
        return localUserService.findAllUsers()
            .map {dbUsers ->
                val transformer = DbUserTransformer()
                dbUsers.map {dbUser ->
                    transformer.transform(dbUser)
                }
            }
    }
}