package fr.android.androidexercises

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {
    // TODO test login activity with Espresso


    @get:Rule
    val activity = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun shouldLoginUser() {
        onView(withId(R.id.usernameEdit)).perform(typeText("b@xebia.fr"))
        onView(withId(R.id.passwordEdit)).perform(typeText("password"),
                closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withId(R.id.loggedText)).check(matches(isDisplayed()))
    }



}