package org.bloodwyn.userdata.data

interface UserServiceExtended {

    fun getUsersWithGender(gender: User.Gender): List<User>

    fun getUsersWithNationality(nation: String): List<String>

}