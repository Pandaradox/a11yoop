package com.pandaradox.a11yoop

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.test.junit4.createComposeRule
import com.pandaradox.a11yoop.color.ForegroundColors
import com.pandaradox.a11yoop.color.backgroundColors
import com.pandaradox.a11yoop.color.checkColorContrast
import com.pandaradox.a11yoop.color.fontColors
import com.pandaradox.a11yoop.core.getA11yTarget
import com.pandaradox.a11yoop.core.setA11yTarget
import com.pandaradox.a11yoop.ui.theme.A11yoopTheme
import org.junit.Rule
import org.junit.Test

class MainActivityColorContrastTest {
    @get:Rule
    val colorContrastTarget = createComposeRule()

    private fun ccWrapper(content: @Composable () -> Unit) =
        colorContrastTarget.setContent { A11yoopTheme { content() } }

    @Test
    fun basicColorContrastFail() {
        ccWrapper { TextColorContrastComponentFail() }

        Log.d("Font Colors: ",
            colorContrastTarget.getA11yTarget().fetchSemanticsNode().config.getOrNull(
                ForegroundColors).toString())
        colorContrastTarget.checkColorContrast()
    }

    @Test
    fun basicColorContrastPass() {
        ccWrapper { TextColorContrastComponentPass() }

        Log.d("Font Colors: ",
            colorContrastTarget.getA11yTarget().fetchSemanticsNode().config.getOrNull(
                ForegroundColors).toString())
        colorContrastTarget.checkColorContrast()
    }
}

@Composable
private fun TextColorContrastComponentFail() =
    Text(text = "Hello Android", modifier = Modifier
        .setA11yTarget()
        .semantics {
            fontColors = listOf(
                Color.Blue,
            )
            backgroundColors = listOf(
                Color.White,
                Color.Yellow,
                Color.Magenta,
                Color.Cyan,
            )
        })

@Composable
private fun TextColorContrastComponentPass() =
    Text(text = "Hello Android", modifier = Modifier
        .setA11yTarget()
        .semantics {
            fontColors = listOf(
                Color(0xFF000000),
            )
            backgroundColors = listOf(
                Color.White,
                Color.Yellow,
                Color.Magenta,
                Color.Cyan,
            )
        })