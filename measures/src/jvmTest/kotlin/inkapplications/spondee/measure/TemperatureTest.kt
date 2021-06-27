package inkapplications.spondee.measure

import inkapplications.spondee.structure.value
import inkapplications.spondee.testConvert
import org.junit.Test
import kotlin.test.assertEquals

class TemperatureTest {
    @Test
    fun conversions() {
        testConvert(123, Kelvin) {
            equals(-150.15, Celsius)
            equals(-238.27, Fahrenheit)
        }
    }
}
