package org.bloodwyn.userdata.data.local

import androidx.room.*
import java.util.*

@Entity(
    tableName = "user",
    primaryKeys = arrayOf("name", "value")
)
class DbUser(
    @Embedded var id: Id
) {
    lateinit var firstName: String

    lateinit var lastName: String

    @TypeConverters(DbUserConverter::class)
    lateinit var gender: Gender

    @TypeConverters(DbUserConverter::class)
    lateinit var birthdayDate: Calendar

    var age: Int = 0

    lateinit var city: String

    lateinit var street: String

    lateinit var state: String

    lateinit var postcode: String


    data class Id(val name: String, val value: String)

    enum class Gender {

        MALE, FEMALE
    }
}