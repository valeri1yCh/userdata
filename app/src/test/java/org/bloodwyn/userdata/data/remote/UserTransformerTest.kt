package org.bloodwyn.userdata.data.remote

import org.bloodwyn.userdata.data.remote.NetworkUser.*
import org.junit.Test
import org.junit.Assert.*
import java.util.*

class UserTransformerTest {

    private val transformer = UserTransformer()

    @Test
    fun transformUserTest() {
        val networkUser = NetworkUser(
            Name("John", "Smith"),
            "FEMALE",
            Location("NY", Location.Street(123, "123"), "NY", "12345")
        )
        networkUser.id = UserId("ffx", "123143214ert")
        networkUser.age = Age(Date(), 25)
        networkUser.phone = "123_456_789"
        val user = transformer.transform(networkUser)
        assertEquals(user.name.firstName, networkUser.name.firstName)
        assertEquals(user.name.lastName, networkUser.name.lastName)
        assertEquals(user.location.city, networkUser.location.city)
        assertEquals(user.location.postcode, networkUser.location.postcode)
        assertEquals(user.location.state, networkUser.location.state)
        assertEquals(user.location.street.name, networkUser.location.street.name)
        assertEquals(user.id.name, networkUser.id.idName)
        assertEquals(user.id.value, networkUser.id.idValue)
        assertEquals(user.phone, networkUser.phone)
        assertEquals(user.age.age, networkUser.age.age)
        assertEquals(user.age.birthdayDate.get(Calendar.YEAR), networkUser.age.birthdayDate.year)
        assertEquals(user.age.birthdayDate.get(Calendar.MONTH), networkUser.age.birthdayDate.month)
        assertEquals(user.age.birthdayDate.get(Calendar.DAY_OF_MONTH), networkUser.age.birthdayDate.day)
        assertEquals(user.gender.toString(), networkUser.gender)
    }
}