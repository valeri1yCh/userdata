package org.bloodwyn.userdata.data.remote

import org.bloodwyn.userdata.data.User
import org.bloodwyn.userdata.data.User.*
import java.util.*

class UserTransformer {

    fun transform(networkUser: NetworkUser): User {
        return User(
            Name(networkUser.name.firstName, networkUser.name.lastName),
            Gender.valueOf(networkUser.gender.toUpperCase(Locale.getDefault())),
            Location(
                networkUser.location.city,
                Location.Street(networkUser.location.street.number, networkUser.location.street.name),
                networkUser.location.state,
                networkUser.location.postcode
            )
        ).apply {
            phone = networkUser.phone
            val age = networkUser.age
            val calendar = Calendar.getInstance()
            calendar.set(age.birthdayDate.year, age.birthdayDate.month, age.birthdayDate.day)
            this.age = Age(calendar, networkUser.age.age)
            val idName = networkUser.id.idName ?: UUID.randomUUID().toString()
            val idValue = networkUser.id.idValue ?: UUID.randomUUID().toString()
            id = Id(idName, idValue)
        }
    }
}