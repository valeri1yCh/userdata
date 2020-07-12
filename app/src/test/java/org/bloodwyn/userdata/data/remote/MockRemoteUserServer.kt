package org.bloodwyn.userdata.data.remote

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.bloodwyn.userdata.data.readFile

/**
 * The mock remote user server for testing. You should call start() method
 * before create responses
 *
 */
class MockRemoteUserServer {

    private val server = MockWebServer()

    fun start() {
        server.start()
    }

    fun start(port: Int) {
        server.start(port)
    }

    fun createEmptyResponse() {
        val response = MockResponse().apply{
            setResponseCode(200)
            server.enqueue(this)
        }
    }

    fun createResponse(code: Int = 200, body: String = " ") {
        val response = MockResponse()
        response.setResponseCode(code)
        response.setBody(body)
        server.enqueue(response)
    }

    fun createNonEmptyResponse(usersCount: Int = 1) {
        val response = MockResponse()
        response.setResponseCode(200)
        response.setBody(readFile("user", this.javaClass))
        server.enqueue(response)
    }

    fun close() {
        server.close()
    }
}