package org.bloodwyn.userdata.view.user

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.bloodwyn.userdata.R
import org.bloodwyn.userdata.data.MockUsersRepository
import org.bloodwyn.userdata.data.ServiceLocator

import org.bloodwyn.userdata.view.TestFragmentFactory
import org.bloodwyn.userdata.view.viewassertion.isRVAdapterHasChildCount
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
@MediumTest
class UsersFragmentTest {

    private lateinit var scenario: FragmentScenario<UsersFragment>


    @Before
    fun setRepository() {
        ServiceLocator.repository = MockUsersRepository()
    }

    @Test
    fun usersFragment_shouldDisplayUsersList() {
        scenario = launchFragmentInContainer(factory = TestFragmentFactory())
        val viewInteraction = onView(withId(R.id.users))
        viewInteraction.check(isRVAdapterHasChildCount(3))
    }
}