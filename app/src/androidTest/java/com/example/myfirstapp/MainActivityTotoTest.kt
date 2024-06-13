package com.example.myfirstapp


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myfirstapp.views.MainActivityTodo

import org.junit.Test
import org.junit.runner.RunWith
import tools.fastlane.screengrab.Screengrab

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTodoInstrumentedTest {
    @Test
    fun test_main_activity_toto_is_displayed() {
        ActivityScenario.launch(MainActivityTodo::class.java)

        // Est ce que la vue correspondant à MainActivityToto est visible
        onView(withId(R.id.main_activity_toto_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_todos_list_is_displayed() {
        ActivityScenario.launch(MainActivityTodo::class.java)
        // Screenshot avant
        onView(withId(R.id.todo_list_recycler_view)).check(matches(isDisplayed()))
        // Screenshot après

        Screengrab.screenshot("screenshot_main_activity_todo");
    }
}