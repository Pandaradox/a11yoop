# A11YOOP
A11yoop is a library solution for Accessibility (A11Y) UI testing in [Jetpack Compose](https://developer.android.com/jetpack/compose).

## Overview
### How does it work?
A11yoop leverages Jetpack Compose's modifier [`semantics`](https://developer.android.com/jetpack/compose/semantics) to provide Composable-Level data structures for maintaining a11y properties.

*See also [A11yoop - Test Components](https://github.com/Pandaradox/a11yoop/tree/main/a11yoop/src/main/java/com/pandaradox/a11yoop/testComponents)* for example usage.

Composables are marked with `a11yTarget` (and possible suffixes for complex Composables) using [`setA11yTarget()`](https://github.com/Pandaradox/a11yoop/blob/ef12b0c5bfd442f23f9c21b62c32b336f4782428/a11yoop/src/main/java/com/pandaradox/a11yoop/core/coreTags.kt#L23). This allows for pinpoint retrieval and access to composable-local semantic properties. With the composable in hand, A11yoop provides methods for testing common a11y checks within UI instrumented testing.  

As test tags and semantics properties are released, they will be publicly available for writing your own UI tests.  

## Getting Started 
#### Using Jitpack
1. Visit [JitPack - A11yoop](https://jitpack.io/#Pandaradox/a11yoop) for the latest release
2. Follow the provided instructions for the release version you are implementing

### Test Tags
A11yoop uses testTags to isolate a component within a scaffold for a11y testing. [`.testTag()`](https://developer.android.com/reference/kotlin/androidx/compose/ui/semantics/package-summary#(androidx.compose.ui.semantics.SemanticsPropertyReceiver).testTag()) is used in jetpack compose to mark a specific node within a complex scaffold while [`.onNodeWithTag()`](https://developer.android.com/reference/kotlin/androidx/compose/ui/test/package-summary#(androidx.compose.ui.test.SemanticsNodeInteractionsProvider).onNodeWithTag(kotlin.String,kotlin.Boolean)) and similar methods are used to retrieve that node.  

### Semantics Properties
*See also [Android Developers - Custom Semantics Properties](https://developer.android.com/jetpack/compose/testing#custom-semantics-properties)*

A11yoop uses Semantics Properties to internally assign essential information for a11y testing. By locally maintaining these values, developers can easily contextualize values for quicker troubleshooting during UI test flows. A11yoop provides property keys so developers can customize tests or use test provided by the library, all of which use out of the box [UI test methods](https://developer.android.com/jetpack/compose/testing) in Jetpack Compose. 

Semantics Properties in A11yoop adhere to this format outlined in the above resource:
```
val {PROPERTY_NAME} = SemanticsPropertyKey<{PROPERTY_TYPE}>("{PROPERTY_NAME}")
var SemanticsPropertyReceiver.{PROPERTY_REFERENCE} by {PROPERTY_NAME}
```

This allows custom data structures within the semantics scope to better organize a11y properties needed for A11yoop.
