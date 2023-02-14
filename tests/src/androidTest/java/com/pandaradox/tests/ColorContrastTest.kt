package com.pandaradox.tests

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import com.pandaradox.a11yoop.color.checkLargeColorContrast
import com.pandaradox.a11yoop.color.checkRegularColorContrast
import com.pandaradox.tests.testComponents.LargeTextColorContrastComponentPass
import com.pandaradox.tests.testComponents.RegularTextColorContrastComponentPass
import org.junit.Rule
import org.junit.Test

class ColorContrastTest {
    @get:Rule
    val colorContrastTarget = createComposeRule()

    private fun ccWrapper(content: @Composable () -> Unit) =
        colorContrastTarget.setContent { MaterialTheme { content() } }

    @Test
    fun regularColorContrastPass() {
        ccWrapper { RegularTextColorContrastComponentPass() }
        colorContrastTarget.checkRegularColorContrast()
    }

    @Test
    fun largeFontColorContrastTest() {
        ccWrapper { LargeTextColorContrastComponentPass() }
        colorContrastTarget.checkLargeColorContrast()
    }
}