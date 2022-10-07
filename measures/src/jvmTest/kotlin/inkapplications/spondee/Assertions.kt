package inkapplications.spondee

import inkapplications.spondee.structure.Dimension
import kotlin.test.assertEquals

fun <D: Dimension<D>> assertEquals(expectedValue: Double, actualValue: D, tolerance: Double = 1e-15) {
    assertEquals(expectedValue, actualValue.value.toDouble(), tolerance)
}
fun <T: Dimension<T>> ExpectationContext<T>.assertEquals(actual: T, tolerance: Double = 1e-15) {
    assertEquals(expected.value.toDouble(), actual.value.toDouble(), tolerance)
}
