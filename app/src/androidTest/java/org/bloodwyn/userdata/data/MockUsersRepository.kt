package org.bloodwyn.userdata.data

import io.reactivex.Maybe
import io.reactivex.Single
import org.bloodwyn.userdata.data.User.*
import java.util.*


/**
 * The mock implementation of [UserRepository]
 */
class MockUsersRepository : UserRepository {

    private var users: List<User> = generateRandomUsers()

    override fun getUsers(): Single<List<User>> {
        return Single.just(users)
    }

    override fun getUserInfo(userId: String): Maybe<User> {
        TODO("Not yet implemented")
    }

    private fun generateRandomUsers(count: Int = 3): List<User> {
        val user1 = User(
            Name("brad", "gibson"),
            Gender.MALE,
            Location(
                "kilcoole",
                Location.Street(12, "Mill Lane"),
                "waterford",
                "93027"
            )
        ).apply {
            id = Id("PPS", "0390511T")
            phone = "011-962-7516"
            val calendar = Calendar.getInstance()
            calendar.set(1995, 1, 1)
            age = Age(calendar, 25)
        }

        val user2 = User(
            Name("Valery", "Chursin"),
            Gender.MALE,
            Location(
                "Sochi",
                Location.Street(13, "Mill Lane"),
                "Krasn krai",
                "354200"
            )
        ).apply {
            id = Id("PPS", "234234234")
            phone = "999-123-1233"
            val calendar2 = Calendar.getInstance()
            calendar2.set(1996, 1, 1)
            age = Age(calendar2, 24)
        }

        val user3 = User(
            Name("John", "Smith"),
            Gender.MALE,
            Location(
                "New_York",
                Location.Street(14, "Mill Lane"),
                "New_York",
                "2342234"
            )
        ).apply {
            phone = "012-324-3249"
            val calendar3 = Calendar.getInstance()
            calendar3.set(1996, 1, 1)
            age = Age(calendar3, 23)
        }

        return arrayListOf(user1, user2, user3)
    }

}