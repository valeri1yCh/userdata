package org.bloodwyn.userdata.data.remote.services

import io.reactivex.Single
import org.bloodwyn.userdata.data.remote.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import org.bloodwyn.userdata.data.remote.NetworkUser

/**
 * A Simple remote user service
 */
interface NetworkSimpleUserService {

    /**
     * The function perform a call to the remote user service and fetch
     * [Response] with [Users]. Exception handling is responsibility of implementation
     * of the interface
     *
     * @param results the count of [NetworkUser] witch remote server will send
     * @return [Single] is contain [Response] from remote server with [Users]
     */
    @GET("?")
    fun getUsers(@Query("results") results: Int): Single<Response<Users>>
}