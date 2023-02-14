package com.pandaradox.tests.testComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.pandaradox.a11yoop.color.backgroundColors
import com.pandaradox.a11yoop.color.foregroundColors
import com.pandaradox.a11yoop.core.setA11yTarget

/**
 * Basic Component for test development meeting 4.5 color contrast ratio
 */
@Composable
fun RegularTextColorContrastComponentPass() {
    val backgroundColor = Color.Black
    val foregroundColor = Color(0xFFEB0000)
    Text(
        text = "RegularText",
        modifier = Modifier
            .background(backgroundColor)
            .setA11yTarget()
            .semantics {
                foregroundColors = listOf(
                    foregroundColor,
                )
                backgroundColors = listOf(
                    backgroundColor,
                )
            },
        color = foregroundColor)
}

/**
 * Basic Component for test development meeting 3.5 color contrast ratio
 */
@Composable
fun LargeTextColorContrastComponentPass() {
    val backgroundColor = Color.Black
    val foregroundColor = Color(0xFFCA0000)
    Text(
        text = "LargeText",
        modifier = Modifier
            .size(35.dp)
            .background(backgroundColor)
            .setA11yTarget()
            .semantics {
                foregroundColors = listOf(
                    foregroundColor,
                )
                backgroundColors = listOf(
                    backgroundColor,
                )
            },
        color = foregroundColor,
    )
}