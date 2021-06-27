package inkapplications.spondee.measure

import inkapplications.spondee.testConvert
import org.junit.Test
import kotlin.test.assertEquals

class PressureTest {
    @Test
    fun conversions() {
        testConvert(123, Pascals) {
            equals(.00123, Bar)
            equals(0.01783964202, Psi)
            equals(0.922575645, MillimetreMercury)
        }
    }
}
