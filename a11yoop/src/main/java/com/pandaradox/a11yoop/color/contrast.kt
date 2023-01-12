package com.pandaradox.a11yoop.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.core.graphics.ColorUtils
import com.pandaradox.a11yoop.core.getA11yTarget

const val redRelativeLuminanceFactor = 0.2126
const val greenRelativeLuminanceFactor = 0.7152
const val blueRelativeLuminanceFactor = 0.0722

fun SemanticsNodeInteractionsProvider.checkColorContrast(index: Int = 0) =
    this.getA11yTarget(index).fetchSemanticsNode().let { node ->
        val possibleViolations = mutableListOf<String>()
        val foregroundColors = node.config.getOrNull(ForegroundColors)
        val backgroundColors = node.config.getOrNull(BackgroundColors)
        foregroundColors?.forEach { foregroundColor: Color ->
            backgroundColors?.forEach { backgroundColor: Color ->
                val contrast =
                    ColorUtils.calculateContrast(foregroundColor.toArgb(), backgroundColor.toArgb())
                if (contrast < 4.5) possibleViolations.add("${
                    foregroundColors.indexOf(foregroundColor)
                }:${
                    backgroundColors.indexOf(backgroundColor)
                }:${String.format("%.2f", contrast)}")
            } ?: assert(false)
        } ?: assert(false)
        assert(possibleViolations.size == 0) { "WARNING: ${possibleViolations.size} possible Color Contrast Violations (Foreground:Background:Contrast): $possibleViolations" }
    }
