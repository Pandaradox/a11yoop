package com.pandaradox.a11yoop.core

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

data class A11yoopCore(
    var foregroundColors: List<Color> = listOf(),
    var backgroundColors: List<Color> = listOf(),
)

val A11yoop = SemanticsPropertyKey<A11yoopCore>("A11yoop")
var SemanticsPropertyReceiver.a11yoop by A11yoop