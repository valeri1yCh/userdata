package org.bloodwyn.userdata.data.dependensys

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.bloodwyn.userdata.data.remote.services.NetworkSimpleUserService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class SimpleNetworkUserServiceImplModule {

    @Provides
    fun provideUserService(): NetworkSimpleUserService {
        val BASE_URL = "https://randomuser.me/api/"
        val httpClient = OkHttpClient()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
        return retrofit.create(NetworkSimpleUserService::class.java)
    }
}