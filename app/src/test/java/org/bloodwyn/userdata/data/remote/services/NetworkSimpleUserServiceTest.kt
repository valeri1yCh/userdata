package org.bloodwyn.userdata.data.remote.services

import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.bloodwyn.userdata.data.remote.Users
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class NetworkSimpleUserServiceTest {

    private lateinit var networkUserService: SimpleNetworkUserServiceImpl

    @Before
    fun setup() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        networkUserService = SimpleNetworkUserServiceImpl(httpClient)
    }

    @Test
    fun getUsers_shouldReturnNonEmptyResult() {
        val observableResponse = networkUserService.getUsers(5)
        observableResponse.subscribe { response ->
            assertEquals(response.code(), 200)
            val networkResponse = response.body()
            assertNotNull(networkResponse?.results)
            assertTrue(networkResponse!!.results.isNotEmpty())
            assertEquals(networkResponse.results.size, 5)
            for (i in networkResponse.results) {
                assertNotNull(i.name)
                assertTrue(i.name.firstName.isNotBlank())
                assertTrue(i.name.lastName.isNotBlank())
                assertTrue(i.phone.isNotBlank())
                assertNotNull(i.age)
                assertTrue(i.gender.isNotBlank())
                assertNotNull(i.location)
                assertNotNull(i.id)
            }
        }
    }

}