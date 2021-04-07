package inkapplications.spondee.math

import org.junit.Test
import kotlin.test.assertEquals

class PercentageTest {
    @Test
    fun conversions() {
        assertEquals(32.0, 32.percent.value)
        assertEquals(32.0, .32.toPercentage().value)
        assertEquals(.32, 32.percent.asFraction())
    }

    @Test
    fun math() {
        assertEquals(500.0, 50.percent of 1000)
        assertEquals(96.percent, 32.percent + 64)
        assertEquals(16.percent, 32.percent - 16)
        assertEquals(-32.0, -(32.percent).value)
        assertEquals(32.0, +(32.percent).value)
        assertEquals(.64, 32.percent * 2)
        assertEquals(.5, 32.percent / .64.percent)
    }

    @Test
    fun string() {
        assertEquals("32.0%", 32.percent.toString())
    }
}
