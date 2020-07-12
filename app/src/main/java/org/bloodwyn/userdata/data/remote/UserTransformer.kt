package org.bloodwyn.userdata.data.remote

import org.bloodwyn.userdata.data.User

class UserTransformer {

    fun transform(networkUser: NetworkUser): User {
        val user = User(
            User.Name(networkUser.name.firstName, networkUser.name.lastName),
            User.Gender.valueOf(networkUser.gender),
            User.Location(
                networkUser.location.city,
                networkUser.location.street.name,
                networkUser.location.state,
                networkUser.location.postcode
            )
        )
        user.phone = networkUser.phone
        user.age = User.Age(networkUser.age.birthdayDate, networkUser.age.age)
        user.id = User.Id(networkUser.id.name, networkUser.id.value)

        return user
    }
}