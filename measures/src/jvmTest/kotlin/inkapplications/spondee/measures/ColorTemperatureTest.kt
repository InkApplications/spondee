package inkapplications.spondee.measures

import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTemperatureTest {
    @Test
    fun miredConversions() {
        12.mireds.run {
            assertEquals(12.0, inMireds)
            assertEquals(83333.3333333, inKelvin, .00000001)
            assertEquals(83333.3333333, asTemperature.inKelvin, .00000001)
        }
        12.kelvin.asColorTemperature.run {
            assertEquals(12.0, inKelvin)
            assertEquals(83333.3333333, inMireds, .00000001)
            assertEquals(12.0, asTemperature.inKelvin)
        }
    }
}
