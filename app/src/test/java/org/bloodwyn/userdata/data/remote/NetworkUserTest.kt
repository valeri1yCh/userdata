package org.bloodwyn.userdata.data.remote

import com.google.gson.Gson
import org.bloodwyn.userdata.data.remote.NetworkUser.*
import org.bloodwyn.userdata.data.readFile
import org.junit.Assert.*
import org.junit.Test

/**
 * Test to convert [NetworkUser] to JSON format and vice versa
 */
class NetworkUserTest {

    private val gson = Gson()

    @Test
    fun createNetworkUserFromJsonTest() {
        val expectedUser = NetworkUser(
            Name("brad", "gibson"),
            "male",
            Location(
                "kilcoole",
                Location.Street(7937, "Mill Lane"),
                "waterford",
                "93027"
            )
        )
        expectedUser.id = UserId("PPS", "0390511T")
        expectedUser.phone = "011-962-7516"

        val jsonString =
            readFile("user.json", this.javaClass)
        val actualUser = gson.fromJson(jsonString, NetworkUser::class.java)
        assertEquals(expectedUser, actualUser)
        assertEquals(expectedUser.id, actualUser.id)
        assertEquals(expectedUser.phone, actualUser.phone)
    }

    @Test
    fun createUsersFromJson() {
        val jsonString = readFile("userslist.json", this::class.java)
        val users = gson.fromJson(jsonString, Users::class.java)
        assertNotNull(users)
        assertTrue(users.results.isNotEmpty())
        for (networkUser in users.results) {
            assertNotNull(networkUser.name)
            assertTrue(networkUser.name.firstName.isNotBlank())
            assertTrue(networkUser.name.lastName.isNotBlank())
            assertTrue(networkUser.phone.isNotBlank())
            assertTrue(networkUser.age.age > 0)
            assertTrue(networkUser.gender.isNotBlank())
            assertNotNull(networkUser.location)
            assertNotNull(networkUser.id.idName)
            assertNotNull(networkUser.id.idValue)
            assertTrue(networkUser.id.idName!!.isNotBlank())
            assertTrue(networkUser.id.idValue!!.isNotBlank())
        }
    }
}