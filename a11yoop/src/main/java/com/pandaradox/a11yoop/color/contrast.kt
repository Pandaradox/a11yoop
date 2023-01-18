package com.pandaradox.a11yoop.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.core.graphics.ColorUtils
import com.pandaradox.a11yoop.core.getA11yTarget

/**
 * A11YOOP method for checking color contrast within a component.
 * Retrieves [foregroundColors] & [backgroundColors] from [getA11yTarget] and compares colors from
 * both lists for Contrast Ratios below 4.5.
 *
 * **See also:** [WCAG - Color Contrast Minimum](https://www.w3.org/WAI/WCAG22/Understanding/contrast-minimum.html)
 *
 * **Violation Report Format:** *ForegroundIndex:BackgroundIndex:ContrastRatio*
 *
 * @param uniqueIdentifier Optional suffix for uniquely retrieving a composable for UI test
 */
fun SemanticsNodeInteractionsProvider.checkRegularColorContrast(uniqueIdentifier: String = "") =
    this.getA11yTarget(uniqueIdentifier).fetchSemanticsNode().let { node ->
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
            } ?: assert(false) { "WARNING: BackgroundColors list is NULL" }
        } ?: assert(false) { "WARNING: BackgroundColors list is NULL" }
        assert(possibleViolations.size == 0) {
            "WARNING: ${possibleViolations.size} possible Color Contrast Violations: $possibleViolations"
        }
    }

/**
 * A11YOOP method for checking color contrast within a component.
 * Retrieves [foregroundColors] & [backgroundColors] from [getA11yTarget] and compares colors from
 * both lists for Contrast Ratios below 3.5.
 *
 * **See also:** [WCAG - Color Contrast Minimum](https://www.w3.org/WAI/WCAG22/Understanding/contrast-minimum.html)
 *
 * **Violation Report Format:** *ForegroundIndex:BackgroundIndex:ContrastRatio*
 *
 * @param uniqueIdentifier Optional suffix for uniquely retrieving a composable for UI test
 */
fun SemanticsNodeInteractionsProvider.checkLargeColorContrast(uniqueIdentifier: String = "") =
    this.getA11yTarget(uniqueIdentifier).fetchSemanticsNode().let { node ->
        val possibleViolations = mutableListOf<String>()
        val foregroundColors = node.config.getOrNull(ForegroundColors)
        val backgroundColors = node.config.getOrNull(BackgroundColors)
        foregroundColors?.forEach { fontColor: Color ->
            backgroundColors?.forEach { backgroundColor: Color ->
                val contrast =
                    ColorUtils.calculateContrast(fontColor.toArgb(), backgroundColor.toArgb())
                if (contrast < 3.5) possibleViolations.add("${
                    foregroundColors.indexOf(fontColor)
                }:${
                    backgroundColors.indexOf(backgroundColor)
                }:${String.format("%.2f", contrast)}")
            } ?: assert(false) { "WARNING: BackgroundColors list is NULL" }
        } ?: assert(false) { "WARNING: ForegroundColors list is NULL" }
        assert(possibleViolations.size == 0) {
            "WARNING: ${possibleViolations.size} possible Color Contrast Violations: $possibleViolations"
        }
    }