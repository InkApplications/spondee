package inkapplications.spondee.measure

import inkapplications.spondee.testConvert
import kotlin.test.Test

class ColorTemperatureTest {
    @Test
    fun miredConversions() {
        testConvert(123, KelvinColorTemperature) {
            equals(8130.08130081, Mireds)
        }
    }
}
