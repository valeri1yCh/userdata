package org.bloodwyn.userdata.data

import java.util.*

data class User(
    var name: Name,
    var gender: Gender,
    var location: Location) {

    lateinit var phone: String
    lateinit var age: Age
    lateinit var id: Id

    data class Name(
        var firstName: String,
        var lastName: String)

    data class Location(
        var city: String,
        var street: Street,
        var state: String,
        var postcode: String) {

        data class Street(var number: Int, var name: String)
    }

    data class Age(var birthdayDate: Calendar, var age: Int)

    data class Id(val name: String, val value: String)

    enum class Gender {
        MALE, FEMALE
    }
}