package inkapplications.spondee.math

import org.junit.Test
import kotlin.test.assertEquals

class PercentageTest {
    @Test
    fun conversions() {
        assertEquals(.32, 32.percent.fraction)
        assertEquals(32.0, .32.asPercentage.whole)
    }

    @Test
    fun math() {
        assertEquals(500.0, 50.percent of 1000)
        assertEquals(96.percent, 32.percent + 64.percent)
        assertEquals(16.percent, 32.percent - 16.percent)
        assertEquals(-32.0, -(32.percent).whole)
        assertEquals(32.0, +(32.percent).whole)
        assertEquals(.64, 32.percent * 2)
        assertEquals(.5, 32.percent / .64)
    }

    @Test
    fun string() {
        assertEquals("32.0%", 32.percent.toString())
    }
}
