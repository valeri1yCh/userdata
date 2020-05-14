package org.bloodwyn.userdata.data.remote.services

import io.reactivex.rxjava3.core.Observable
import org.bloodwyn.userdata.data.remote.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkSimpleUserService {

    @GET("?")
    fun findUsers(@Query("results") results: Int): Observable<Response<Users>>
}