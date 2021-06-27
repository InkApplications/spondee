package inkapplications.spondee

import inkapplications.spondee.structure.StoredUnit
import inkapplications.spondee.structure.DoubleMeasurement
import inkapplications.spondee.structure.DoubleUnit
import kotlin.test.assertEquals

fun <T: DoubleMeasurement<T>> assertConverts(expected: T, actual: T, tolerance: Double = 1e-10) {
    assertEquals(expected.rawValue, actual.rawValue, tolerance)
}

class MeasurementAssertions<T: DoubleMeasurement<T>>(
    private val storedValue: Double,
    private val storedUnit: StoredUnit<T>,
) {
    fun equals(
        expectedValue: Number,
        expectedUnit: DoubleUnit<T>,
        tolerance: Double = 1e-10
    ) {
        assertEquals(expectedValue, expectedUnit, storedValue, storedUnit, tolerance)
        assertEquals(storedValue, storedUnit, expectedValue, expectedUnit, tolerance)
    }

    private fun assertEquals(
        expectedValue: Number,
        expectedUnit: DoubleUnit<T>,
        actualValue: Number,
        actualUnit: DoubleUnit<T>,
        tolerance: Double = 1e-10
    ) {
        val actualBaseValue = actualUnit.of(actualValue).rawValue
        val expectedBaseValue = expectedUnit.of(expectedValue).rawValue
        assertEquals(
            expected = expectedBaseValue,
            actual = actualBaseValue,
            absoluteTolerance = tolerance,
            message = "${actualUnit::class.simpleName} failed to convert to ${expectedUnit::class.simpleName}"
        )
    }
}

fun <T: DoubleMeasurement<T>> testConvert(value: Number, unit: StoredUnit<T>, assertions: MeasurementAssertions<T>.() -> Unit) {
    assertions(MeasurementAssertions(value.toDouble(), unit))
}
