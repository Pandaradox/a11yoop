package com.pandaradox.a11yoop.core

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst

/**
 * Constant used as a test tag in [setA11yTarget] for retrieval in UI tests.
 *
 * Value: "a11yTarget"
 */
const val A11Y_TARGET = "a11yTarget"

/**
 * A11YOOP method for marking a composable with [A11Y_TARGET] for UI test retrieval.
 * If multiple components are marked, use [uniqueIdentifier] to distinguish between components.
 *
 * @param uniqueIdentifier Optional suffix for uniquely marking a composable for UI test retrieval
 * @return [Modifier]
 */
fun Modifier.setA11yTarget(uniqueIdentifier: String = "") =
    this.testTag(A11Y_TARGET + uniqueIdentifier)

/**
 * A11YOOP method for retrieving a composable with [A11Y_TARGET] for UI tests.
 * If multiple components are marked, use [uniqueIdentifier] to distinguish between components.
 *
 * @param uniqueIdentifier Optional suffix for uniquely retrieving a composable for UI test
 * @return
 */
fun SemanticsNodeInteractionsProvider.getA11yTarget(uniqueIdentifier: String = "") =
    this.onAllNodesWithTag(A11Y_TARGET + uniqueIdentifier).onFirst()
