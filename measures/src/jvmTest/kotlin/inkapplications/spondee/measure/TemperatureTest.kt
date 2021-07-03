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

    @Test
    fun formats() {
        assertEquals("32.0ºF", Fahrenheit.of(32).let { Fahrenheit.format(it) })
        assertEquals("0.0ºC", Celsius.of(0).let { Celsius.format(it) })
        assertEquals("0.0K", Kelvin.of(0).let { Kelvin.format(it) })
    }
}
