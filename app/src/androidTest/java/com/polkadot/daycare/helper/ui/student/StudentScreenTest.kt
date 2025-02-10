package com.polkadot.daycare.helper.ui.student

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.polkadot.daycare.helper.data.models.fakeStudents
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI tests for [StudentsScreen].
 */
@RunWith(AndroidJUnit4::class)
class StudentScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            StudentsScreen(fakeStudents, onSave = {}, onNavigateToStudentDetails = { _: Int, _: Int -> })
        }
    }

    @Test
    fun firstItem_exists() {
        composeTestRule.onNodeWithText(fakeStudents.first().firstName).assertExists().performClick()
    }
}

