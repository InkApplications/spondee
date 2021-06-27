package inkapplications.spondee.structure

import inkapplications.spondee.measure.Meters
import kotlin.test.Test
import kotlin.test.assertEquals

class MeasurementTest {
    @Test
    fun siUnits() {
        assertEquals(12.0, Meters.of(12_000).value(Kilo, Meters))
    }

    @Test
    fun math() {
        assertEquals(Meters.of(5), Meters.of(2) + Meters.of(3))
        assertEquals(Meters.of(6), Meters.of(8) - Meters.of(2))
        assertEquals(Meters.of(8), Meters.of(4) * 2)
        assertEquals(Meters.of(4), Meters.of(8) / 2)
        assertEquals(Meters.of(1), Meters.of(5) % Meters.of(4))
    }
}
