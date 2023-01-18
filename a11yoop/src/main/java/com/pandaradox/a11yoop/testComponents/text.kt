package com.pandaradox.a11yoop.testComponents

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


@Composable
fun RegularTextColorContrastComponentPass() =
    Text(
        text = "RegularText",
        modifier = Modifier
            .background(Color.White)
            .setA11yTarget()
            .semantics {
                foregroundColors = listOf(
                    Color.Black,
                )
                backgroundColors = listOf(
                    Color.White,
                )
            },
        color = Color.Black)

@Composable
fun LargeTextColorContrastComponentPass() =
    Text(
        text = "LargeText",
        modifier = Modifier
            .size(35.dp)
            .background(Color.Red)
            .setA11yTarget()
            .semantics {
                foregroundColors = listOf(
                    Color.Black,
                )
                backgroundColors = listOf(
                    Color.Red,
                )
            },
        color = Color.Black,
    )