package org.bloodwyn.userdata.data.local.services

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import io.reactivex.observers.TestObserver
import io.reactivex.subscribers.TestSubscriber
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.bloodwyn.userdata.data.local.DbUser
import org.bloodwyn.userdata.data.local.UserInfoAppDatabase
import org.junit.*
import org.junit.runner.RunWith


/**
 * The test class for [ReadUserService]
 */
class ReadUserServiceTest {

    private lateinit var dataBase: UserInfoAppDatabase
    private lateinit var readUserService: ReadUserService

    @Before
    fun createDatabaseAndUserDao() {
        dataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserInfoAppDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        readUserService = ReadUserService(dataBase.userDao())
    }

    @Before
    fun populateDb() {
        val writeUserDao = dataBase.writeUserDao()
        writeUserDao.insertAll(users)
            .subscribe()
    }

    @Test
    fun findAllUsersTest() {
        readUserService.findAllUsers()
            .test()
            .assertComplete()
            .assertValue(users)
    }

    @Test
    fun findByIdTest() {
        val user = users[0]
        readUserService.findById(user.id.name, user.id.value)
            .test()
            .assertComplete()
            .assertValue(user)
    }

    @After
    fun closeDb() {
        dataBase.close()
    }
}