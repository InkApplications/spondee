package inkapplications.spondee.measures

import kotlin.test.assertTrue

fun assertEquals(expected: Double, actual: Double, delta: Double) {
    assertTrue(expected - actual < delta, "Expected value <$expected> with delta <$delta>, actual <$actual>")
}
