package com.nabin.instagramcloneapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@LargeTest
@RunWith(JUnit4::class)
class LoginTesting{
    @get: Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun LoginTestUI(){
        Espresso.onView(withId(R.id.tvusername))
                .perform(ViewActions.typeText("hero"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.tvpassword))
                .perform(ViewActions.typeText("gameon@123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.btnlogin))
                .perform(ViewActions.click())
        Espresso.closeSoftKeyboard()


        Thread.sleep(1000)

        Espresso.onView(withId(R.id.tvuserex))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}
