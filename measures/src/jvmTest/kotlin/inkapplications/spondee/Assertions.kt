package inkapplications.spondee

import inkapplications.spondee.structure.BaseUnit
import inkapplications.spondee.structure.Measurement
import inkapplications.spondee.structure.MeasurementUnit
import kotlin.test.assertEquals

fun <T: Measurement<T>> assertConverts(expected: T, actual: T, tolerance: Double = 1e-10) {
    assertEquals(expected.baseValue, actual.baseValue, tolerance)
}

class MeasurementAssertions<T: Measurement<T>>(
    private val baseValue: Double,
    private val baseUnit: BaseUnit<T>,
) {
    fun equals(
        expectedValue: Number,
        expectedUnit: MeasurementUnit<T>,
        tolerance: Double = 1e-10
    ) {
        assertEquals(expectedValue, expectedUnit, baseValue, baseUnit, tolerance)
        assertEquals(baseValue, baseUnit, expectedValue, expectedUnit, tolerance)
    }

    private fun assertEquals(
        expectedValue: Number,
        expectedUnit: MeasurementUnit<T>,
        actualValue: Number,
        actualUnit: MeasurementUnit<T>,
        tolerance: Double = 1e-10
    ) {
        val actualBaseValue = actualUnit.of(actualValue).baseValue
        val expectedBaseValue = expectedUnit.of(expectedValue).baseValue
        assertEquals(
            expected = expectedBaseValue,
            actual = actualBaseValue,
            absoluteTolerance = tolerance,
            message = "${actualUnit::class.simpleName} failed to convert to ${expectedUnit::class.simpleName}"
        )
    }
}

fun <T: Measurement<T>> testConvert(value: Number, unit: BaseUnit<T>, assertions: MeasurementAssertions<T>.() -> Unit) {
    assertions(MeasurementAssertions(value.toDouble(), unit))
}
