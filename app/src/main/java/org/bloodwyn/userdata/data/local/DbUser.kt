package org.bloodwyn.userdata.data.local

import androidx.room.*
import java.util.*

@Entity(
    tableName = "user"
)
data class DbUser(
   @PrimaryKey @Embedded var id: Id
) {
    lateinit var firstName: String

    lateinit var lastName: String

    lateinit var gender: Gender

    lateinit var birthdayDate: Calendar

    var age: Int = 0

    lateinit var city: String

    lateinit var street: String

    lateinit var state: String

    lateinit var postcode: String

    data class Id(var name: String, var value: String)

    enum class Gender {

        MALE, FEMALE
    }
}