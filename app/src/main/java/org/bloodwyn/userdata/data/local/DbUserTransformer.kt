package org.bloodwyn.userdata.data.local

import org.bloodwyn.userdata.data.Transformer
import org.bloodwyn.userdata.data.User
import org.bloodwyn.userdata.data.User.*

/**
 * The implementation of [Transformer]. Transform
 * [DbUser] to [User]
 *
 */
class DbUserTransformer: Transformer<DbUser, User> {

    override fun transform(dbUser: DbUser): User {

        val userLocation = Location(
            dbUser.location.city,
            Location.Street(dbUser.location.street.number, dbUser.location.street.name),
            dbUser.location.state,
            dbUser.location.postcode
        )
        val userName = Name(dbUser.name.firstName, dbUser.name.lastName)

        val user = User(
            userName,
            Gender.valueOf(dbUser.gender.name),
            userLocation
        ).apply {
            age = Age(dbUser.birthdayDate, dbUser.age)
            phone = dbUser.phone
            id = Id(dbUser.id.name, dbUser.id.value)
        }

        return user
    }
}