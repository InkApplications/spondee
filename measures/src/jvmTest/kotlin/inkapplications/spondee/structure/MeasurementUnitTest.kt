package inkapplications.spondee.structure

import inkapplications.spondee.measure.Meters
import kotlin.test.Test
import kotlin.test.assertEquals

class MeasurementUnitTest {
    @Test
    fun siUnits() {
        assertEquals(12_000.0, Meters.of(Kilo, 12).value(Meters))
    }
}
