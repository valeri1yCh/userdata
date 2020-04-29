package org.bloodwyn.userdata.data

import java.util.*

data class User(var name: Name, var gender: Gender, var location: Location) {

    data class Name(var firstName: String, var lastName: String)

    data class Location(var city: String, var street: String, var state: String, var postcode: Int)

    data class Age(var birthdayDate: Date, var age: Int)

    enum class Gender {
        MALE, FEMALE
    }
}