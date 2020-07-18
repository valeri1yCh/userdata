package org.bloodwyn.userdata.data.local.services

import org.bloodwyn.userdata.data.local.DbUser
import org.bloodwyn.userdata.data.local.DbUser.Id
import java.util.*
import kotlin.collections.ArrayList

val users = ArrayList<DbUser>().apply {
    val user1 = DbUser(Id("ffx", "12345678"))
    user1.firstName = "John"
    user1.lastName = "Smith"
    user1.age = 25
    val birthDate1 = Calendar.getInstance()
    birthDate1.set(1995, 5, 5)
    user1.birthdayDate = birthDate1
    user1.city = "NY"
    user1.postcode = "1234321"
    user1.street = "qwer"
    user1.state = "NY"
    user1.gender = DbUser.Gender.MALE

    val user2 = DbUser(Id("ffx", "2342346vfff"))
    user2.firstName = "Mellisa"
    user2.lastName = "Ann"
    user2.age = 22
    val birthDate2 = Calendar.getInstance()
    birthDate2.set(1997, 1, 10)
    user2.birthdayDate = birthDate2
    user2.city = "Stanton"
    user2.postcode = "655322"
    user2.street = "bvcn"
    user2.state = "Stanton"
    user2.gender = DbUser.Gender.FEMALE

    val user3 = DbUser(Id("ddx", "gdsg438534"))
    user3.firstName = "Arnold"
    user3.lastName = "Shvartz"
    user3.age = 70
    val birthDate3 = Calendar.getInstance()
    birthDate3.set(1950, 3, 2)
    user3.birthdayDate = birthDate3
    user3.city = "California"
    user3.postcode = "098753"
    user3.street = "gggggr"
    user3.state = "California"
    user3.gender = DbUser.Gender.MALE

    val user4 = DbUser(Id("ffx", "hgdsfhg324423"))
    user4.firstName = "Terri"
    user4.lastName = "Lock"
    user4.age = 50
    val birthDate4 = Calendar.getInstance()
    birthDate4.set(1970, 2, 2)
    user4.birthdayDate = birthDate4
    user4.city = "NY"
    user4.postcode = "345345"
    user4.street = "qaz"
    user4.state = "NY"
    user4.gender = DbUser.Gender.MALE
    add(user1)
    add(user2)
    add(user3)
    add(user4)
}