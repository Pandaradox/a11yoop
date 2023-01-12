package com.pandaradox.a11yoop.core

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.onAllNodesWithTag

val A11Y_TARGET = "a11yTarget"

fun Modifier.setA11yTarget() = this.testTag(A11Y_TARGET)

fun SemanticsNodeInteractionsProvider.getA11yTarget(index: Int = 0) =
    this.onAllNodesWithTag(A11Y_TARGET)[index]
