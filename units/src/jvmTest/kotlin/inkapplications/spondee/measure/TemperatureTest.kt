package inkapplications.spondee.measure

import inkapplications.spondee.assertEquals
import inkapplications.spondee.measure.metric.celsius
import inkapplications.spondee.measure.metric.kelvin
import inkapplications.spondee.measure.metric.toCelsius
import inkapplications.spondee.measure.us.fahrenheit
import inkapplications.spondee.measure.us.toFahrenheit
import inkapplications.spondee.structure.value
import inkapplications.spondee.withExpectation
import org.junit.Test
import kotlin.test.assertEquals

class TemperatureTest {
    @Test
    fun conversions() {
        with(123.kelvin) {
            assertEquals(123.0, toKelvin().value.toDouble(), 1e-10)
            assertEquals(-150.15, toCelsius().value.toDouble(), 1e-10)
            assertEquals(-238.27, toFahrenheit().value.toDouble(), 1e-10)
        }
        withExpectation(123.kelvin) {
            assertEquals(123.kelvin.toKelvin(), 1e-10)
            assertEquals((-150.15).celsius.toKelvin(), 1e-10)
            assertEquals((-238.27).fahrenheit.toKelvin(), 1e-10)
        }
    }

    @Test
    fun formats() {
        assertEquals("0ºF", 0.fahrenheit.toString())
        assertEquals("0ºC", 0.celsius.toString())
        assertEquals("0K", 0.kelvin.toString())
    }
}
