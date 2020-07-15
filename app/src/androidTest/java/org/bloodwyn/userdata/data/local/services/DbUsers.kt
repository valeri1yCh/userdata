package org.bloodwyn.userdata.data.local.services

import org.bloodwyn.userdata.data.local.DbUser
import org.bloodwyn.userdata.data.local.DbUser.Id
import java.util.*

private var dbUsers: List<DbUser> = emptyList()

fun createUsers(): List<DbUser> {
    if(dbUsers.isEmpty()) {
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

        val user3 = DbUser(Id("ffx", "gdsg438534"))
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

        dbUsers = arrayListOf(user1, user2, user3, user4)
    }

    return dbUsers
}