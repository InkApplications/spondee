package inkapplications.spondee.scalar

import inkapplications.spondee.testConvert
import org.junit.Test
import kotlin.test.assertEquals

class PercentageTest {
    @Test
    fun conversions() {
        testConvert(.32, DecimalPercentage) {
            equals(32, WholePercentage)
        }
    }

    @Test
    fun math() {
        // TODO
//        assertEquals(500.0, 50.percent of 1000)
//        assertEquals(96.percent, 32.percent + 64.percent)
//        assertEquals(16.percent, 32.percent - 16.percent)
//        assertEquals(-32.0, -(32.percent).whole)
//        assertEquals(32.0, +(32.percent).whole)
//        assertEquals(.64, 32.percent * 2)
//        assertEquals(.5, 32.percent / .64)
    }
}
