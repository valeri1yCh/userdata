package org.bloodwyn.userdata.data.local

import androidx.room.*
import java.util.*

/**
 * DTO
 */
@Entity(
    tableName = "user"
)
data class DbUser(
   @PrimaryKey @Embedded var id: Id
) {
    @Embedded lateinit var name: Name

    @Embedded lateinit var location: Location

    lateinit var gender: Gender

    lateinit var birthdayDate: Calendar

    lateinit var phone: String

    var age: Int = 0

    data class Name(
        var firstName: String,
        var lastName: String)

    data class Id(var name: String, var value: String)

    data class Location(
        var city: String,
        var street: Street,
        var state: String,
        var postcode: String) {

        data class Street(var number: Int, var name: String)
    }

    enum class Gender {
        MALE, FEMALE
    }
}