package com.pandaradox.a11yoop.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val ForegroundColors = SemanticsPropertyKey<List<Color>>("ForegroundColors")
var SemanticsPropertyReceiver.fontColors by ForegroundColors

val BackgroundColors = SemanticsPropertyKey<List<Color>>("BackgroundColors")
var SemanticsPropertyReceiver.backgroundColors by BackgroundColors
