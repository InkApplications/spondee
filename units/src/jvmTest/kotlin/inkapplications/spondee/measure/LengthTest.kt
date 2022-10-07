package inkapplications.spondee.measure

import inkapplications.spondee.assertEquals
import inkapplications.spondee.measure.metric.meters
import inkapplications.spondee.measure.us.*
import inkapplications.spondee.withExpectation
import kotlin.test.Test
import kotlin.test.assertEquals

class LengthTest {
    @Test
    fun conversions() {
        with(123.meters) {
            assertEquals(403.54332, toFeet().value.toDouble(), 1e-15)
            assertEquals(4842.51984, toInches().value.toDouble(), 1e-15)
            assertEquals(134.51444, toYards().value.toDouble(), 1e-15)
            assertEquals(0.07642865909, toMiles().value.toDouble(), 1e-11)
        }

        withExpectation(123.meters) {
            assertEquals(403.54332.feet.toMeters(), 1e-15)
            assertEquals(4842.51984.inches.toMeters(), 1e-15)
            assertEquals(134.51444.yards.toMeters(), 1e-15)
            assertEquals(0.07642865909.miles.toMeters(), 1e-8)
        }
    }

    @Test
    fun formats() {
        assertEquals("123m", 123.meters.toString())
        assertEquals("123in", 123.inches.toString())
        assertEquals("123ft", 123.feet.toString())
        assertEquals("123yd", 123.yards.toString())
        assertEquals("123mi", 123.miles.toString())
    }
}
