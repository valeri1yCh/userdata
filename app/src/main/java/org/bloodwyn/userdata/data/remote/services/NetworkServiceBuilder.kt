package org.bloodwyn.userdata.data.remote.services

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter

interface NetworkServiceBuilder {

    fun build(baseUrl: String, factory: Converter.Factory, adapter: CallAdapter.Factory, client: OkHttpClient): NetworkSimpleUserService
}