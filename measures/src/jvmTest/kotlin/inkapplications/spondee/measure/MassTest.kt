package inkapplications.spondee.measure

import inkapplications.spondee.assertEquals
import inkapplications.spondee.measure.metric.grams
import inkapplications.spondee.measure.metric.metricTons
import inkapplications.spondee.measure.metric.toMetricTons
import inkapplications.spondee.measure.us.*
import inkapplications.spondee.withExpectation
import kotlin.test.Test
import kotlin.test.assertEquals

class MassTest {
    @Test
    fun conversions() {
        with(123.grams) {
            assertEquals(123.0, toGrams(), 1e-8)
            assertEquals(1898.18007741, toGrains(), 1e-8)
            assertEquals(69.4191571167, toDrams(), 1e-8)
            assertEquals(4.33869731979, toOunces(), 1e-11)
            assertEquals(.27116858248, toPounds(), 1e-11)
            assertEquals(.00271168582, toShortHundredweights(), 1e-11)
            assertEquals(.00013558429, toShortTons(), 1e-11)
            assertEquals(.00012105740, toLongTons(), 1e-11)
            assertEquals(0.000123, toMetricTons(), 1e-6)
        }
        withExpectation(123.grams) {
            assertEquals(123.grams.toGrams())
            assertEquals(1898.18007741.grains.toGrams(), 1e-8)
            assertEquals(69.4191571167.drams.toGrams(), 1e-8)
            assertEquals(4.33869731979.ounces.toGrams(), 1e-9)
            assertEquals(.27116858248.pounds.toGrams(), 1e-8)
            assertEquals(.00271168582.shortHundredweights.toGrams(), 1e-6)
            assertEquals(.00013558429.shortTons.toGrams(), 1e-4)
            assertEquals(.00012105740.longTons.toGrams(), 1e-4)
            assertEquals(0.000123.metricTons.toGrams(), 1e-6)
        }
    }

    @Test
    fun format() {
        assertEquals("123g", 123.grams.toString())
        assertEquals("123dr", 123.drams.toString())
        assertEquals("123oz", 123.ounces.toString())
        assertEquals("123lbs", 123.pounds.toString())
        assertEquals("123cwt", 123.shortHundredweights.toString())
        assertEquals("123ST", 123.shortTons.toString())
        assertEquals("123LT", 123.longTons.toString())
        assertEquals("123t", 123.metricTons.toString())
    }
}
