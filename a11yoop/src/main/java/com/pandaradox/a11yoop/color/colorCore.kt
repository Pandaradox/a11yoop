package com.pandaradox.a11yoop.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val ForegroundColors = SemanticsPropertyKey<List<Color>>("ForegroundColors")

/**
 * A11YOOP property for collecting foreground colors as a List<Color>
 */
var SemanticsPropertyReceiver.foregroundColors by ForegroundColors


val BackgroundColors = SemanticsPropertyKey<List<Color>>("BackgroundColors")

/**
 * A11YOOP property for collecting background colors as a List<Color>
 */
var SemanticsPropertyReceiver.backgroundColors by BackgroundColors
