package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.kelvin
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTemperatureTest {
    @Test
    fun miredConversions() {
        assertEquals(2000.0, 500.mireds.toKelvin().value.toDouble(), 1e-15)
        assertEquals(500.0, 2000.kelvin.toMireds().value.toDouble(), 1e-15)
    }

    @Test
    fun format() {
        assertEquals("123MK^-1", 123.mireds.toString())
    }
}
