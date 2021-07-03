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
    fun formats() {
        assertEquals("0.0", DecimalPercentage.of(0).let { DecimalPercentage.format(it) })
        assertEquals("0.0%", WholePercentage.of(0).let { WholePercentage.format(it) })
    }
}
