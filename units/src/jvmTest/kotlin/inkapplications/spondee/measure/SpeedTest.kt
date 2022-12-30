package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.kilometersPerHour
import inkapplications.spondee.measure.metric.metersPerSecond
import inkapplications.spondee.measure.metric.toKilometersPerHourValue
import inkapplications.spondee.measure.metric.toMetersPerSecondValue
import inkapplications.spondee.measure.us.*
import inkapplications.spondee.structure.toDouble
import kotlin.test.Test
import kotlin.test.assertEquals

class SpeedTest {
    @Test
    fun conversions() {
        with(123.metersPerSecond) {
            assertEquals(123.0, toMetersPerSecondValue(), 1e-15)
            assertEquals(442.8, toKilometersPerHourValue(), 1e-15)
            assertEquals(275.143, toMilesPerHourValue(), 1e-3)
            assertEquals(403.543, toFeetPerSecondValue(), 1e-3)
            assertEquals(239.093, toKnots().toDouble(), 1e-3)
        }
        with(123.kilometersPerHour) {
            assertEquals(34.16666666666666, toMetersPerSecondValue(), 1e-14)
            assertEquals(123.0, toKilometersPerHourValue(), 1e-15)
            assertEquals(76.4287, toMilesPerHourValue(), 1e-4)
            assertEquals(112.095, toFeetPerSecondValue(), 1e-3)
            assertEquals(66.4147, toKnots().toDouble(), 1e-4)
        }
        with(123.milesPerHour) {
            assertEquals(54.9859, toMetersPerSecondValue(), 1e-4)
            assertEquals(197.949, toKilometersPerHourValue(), 1e-3)
            assertEquals(123.0, toMilesPerHourValue(), 1e-15)
            assertEquals(180.4, toFeetPerSecondValue(), 1e-15)
            assertEquals(106.884, toKnots().toDouble(), 1e-3)
        }
        with(123.feetPerSecond) {
            assertEquals(37.4904, toMetersPerSecondValue(), 1e-4)
            assertEquals(134.965, toKilometersPerHourValue(), 1e-3)
            assertEquals(83.8636, toMilesPerHourValue(), 1e-4)
            assertEquals(123.0, toFeetPerSecondValue(), 1e-15)
            assertEquals(72.8755, toKnots().toDouble(), 1e-4)
        }
        with(123.knots) {
            assertEquals(63.2767, toMetersPerSecondValue(), 1e-4)
            assertEquals(227.796, toKilometersPerHourValue(), 1e-3)
            assertEquals(141.546, toMilesPerHourValue(), 1e-3)
            assertEquals(207.601, toFeetPerSecondValue(), 1e-3)
            assertEquals(123.0, toKnots().toDouble(), 1e-15)
        }
    }
}
