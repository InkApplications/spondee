package inkapplications.spondee.measure

import inkapplications.spondee.testConvert
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTemperatureTest {
    @Test
    fun miredConversions() {
        testConvert(123, KelvinColorTemperature) {
            equals(8130.08130081, Mireds)
        }
    }

    @Test
    fun formats() {
        assertEquals("0.0K", KelvinColorTemperature.of(0).let { KelvinColorTemperature.format(it) })
        assertEquals("0.0K^-1", Mireds.of(0).let { Mireds.format(it) })
    }
}
