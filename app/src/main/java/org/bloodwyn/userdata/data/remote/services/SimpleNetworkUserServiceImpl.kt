package org.bloodwyn.userdata.data.remote.services

import io.reactivex.Single
import okhttp3.OkHttpClient
import org.bloodwyn.userdata.application.UserDataApplication
import org.bloodwyn.userdata.data.remote.Users
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

private const val BASE_URL = "https://randomuser.me/api/"
private val defaultHttpClient = OkHttpClient()

class SimpleNetworkUserServiceImpl @Inject constructor(
    private val userService: NetworkSimpleUserService
) : NetworkSimpleUserService {

    init {
        UserDataApplication.simpleNetworkUserServiceComponent.inject(this)
    }

    override fun getUsers(limit: Int): Single<Response<Users>> {
        return userService.getUsers(limit)
    }
}