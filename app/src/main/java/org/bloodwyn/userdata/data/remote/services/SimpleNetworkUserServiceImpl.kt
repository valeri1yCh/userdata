package org.bloodwyn.userdata.data.remote.services

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import org.bloodwyn.userdata.data.remote.Users
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://randomuser.me/api/"
private val defaultHttpClient = OkHttpClient()

class SimpleNetworkUserServiceImpl(val httpClient: OkHttpClient = defaultHttpClient) {

    private lateinit var userService: NetworkSimpleUserService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(httpClient)
            .build()
        userService = retrofit.create(NetworkSimpleUserService::class.java)
    }

    fun getUsers(limit: Int): Observable<Response<Users>> {
        return userService.findUsers(limit)
    }
}