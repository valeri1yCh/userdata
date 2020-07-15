package org.bloodwyn.userdata.data.local.services

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import junit.framework.TestCase.assertTrue
import org.bloodwyn.userdata.data.local.UserInfoAppDatabase
import org.junit.*
import org.junit.runner.RunWith


/**
 * The test class for [ReadUserService]
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class ReadUserServiceTest {

    private lateinit var dataBase: UserInfoAppDatabase
    private lateinit var readUserService: ReadUserService

    @Before
    fun createBdAndUserDao() {
        dataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserInfoAppDatabase::class.java
        ).allowMainThreadQueries().build()
        readUserService = ReadUserService(dataBase.userDao())
    }

    @Before
    fun populateDb() {
        val writeUserDao = dataBase.writeUserDao()
        writeUserDao.insertAll(createUsers())
    }

    @Test
    fun findAllUsersTest() {
        readUserService.findAllUsers()
            .test()
            .assertComplete()
            .assertValueCount(4)
            .assertValues(createUsers())
        assertTrue(false)
    }

    @After
    fun closeDb() {
        dataBase.close()
    }
}