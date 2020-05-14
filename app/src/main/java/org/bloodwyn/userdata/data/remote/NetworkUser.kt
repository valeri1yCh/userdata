package org.bloodwyn.userdata.data.remote

import com.google.gson.annotations.SerializedName
import java.util.*

data class NetworkUser(
    @SerializedName("name") var name: Name,
    @SerializedName("gender") var gender: String,
    @SerializedName("location") var location: Location) {

    @SerializedName("dob")
    lateinit var age: Age

    @SerializedName("phone")
    lateinit var phone: String

    lateinit var id: Id

    data class Name(
        @SerializedName("first") var firstName: String,
        @SerializedName("last") var lastName: String)

    data class Location(var city: String, var street: Street, var state: String, var postcode: String) {
        data class Street(var number: Int, var name: String)
    }

    data class Age(@SerializedName("date") var birthdayDate: Date, var age: Int)

    data class Id(val name: String, val value: String)

}