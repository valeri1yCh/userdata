package org.bloodwyn.userdata.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user")
class DbUser(
    var name: Name,
    var gender: Gender,
    var location: Location) {

    lateinit var age: Age

    @PrimaryKey
    lateinit var id: Id

    data class Name(
         var firstName: String,
         var lastName: String)

    data class Location(var city: String, var street: String, var state: String, var postcode: Int)

    data class Age(var birthdayDate: Date, var age: Int)

    data class Id(val name: String, val value: String)

    enum class Gender {

        MALE, FEMALE
    }
}