package com.pandaradox.a11yooplab

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import com.pandaradox.a11yoop.core.getA11yTarget
import com.pandaradox.a11yooplab.labComponents.RegularTextColorContrastComponentPass
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class A11yoopLabTest {
    @get:Rule
    val testTarget = createComposeRule()

    private fun testWrapper(content: @Composable () -> Unit) =
        testTarget.setContent(content)

    @Ignore("Sandbox Test. Do not run with Bitrise.")
    @Test
    fun seeNodeConfig() {
        testWrapper { RegularTextColorContrastComponentPass() }
        Log.i("Node Config: ",
            testTarget.getA11yTarget().fetchSemanticsNode().config.toString())
    }
}