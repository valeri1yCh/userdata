package org.bloodwyn.userdata.data

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

/**
 * The mock implementation of [UserRepository]
 */
class MockUsersRepository : UserRepository {

    var userList: List<User> = generateRandomUsers()

    override fun getUsers(): Observable<List<User>> {

        return Observable.just(userList)
    }

    override fun getUserInfo(userId: String): Maybe<User> {
        TODO("Not yet implemented")
    }

    private fun generateRandomUsers(count: Int = 3): List<User> {
        val user1 = User(
            User.Name("brad", "gibson"),
            User.Gender.MALE,
            User.Location(
                "kilcoole",
                "Mill Lane",
                "waterford",
                "93027"
            )
        )
        user1.id = User.Id("PPS", "0390511T")
        user1.phone = "011-962-7516"

        val user2 = User(
            User.Name("Valery", "Chursin"),
            User.Gender.MALE,
            User.Location(
                "Sochi",
                "Mayakovskogo",
                "Krasn krai",
                "354200"
            )
        )
        user2.id = User.Id("PPS", "234234234")
        user2.phone = "999-123-1233"

        val user3 = User(
            User.Name("John", "Smith"),
            User.Gender.MALE,
            User.Location(
                "New_York",
                "GGC",
                "New_York",
                "2342234"
            )
        )
        user3.phone = "012-324-3249"

        return arrayListOf(user1, user2, user3)
    }

}