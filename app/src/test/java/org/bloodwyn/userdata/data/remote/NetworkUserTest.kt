package org.bloodwyn.userdata.data.remote


import com.google.gson.Gson
import org.bloodwyn.userdata.data.remote.NetworkUser.*
import org.bloodwyn.userdata.data.readFile
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NetworkUserTest {

    private lateinit var gson: Gson

    @Before
    fun setup() {
        gson = Gson()
    }

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
        expectedUser.id = Id("PPS", "0390511T")
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
        for (i in users.results) {
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