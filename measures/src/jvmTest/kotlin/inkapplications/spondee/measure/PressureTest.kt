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

    @Test
    fun formats() {
        assertEquals("0.0Pa", Pascals.of(0).let { Pascals.format(it) })
        assertEquals("0.0bar", Bar.of(0).let { Bar.format(it) })
        assertEquals("0.0psi", PoundsPerSquareInch.of(0).let { PoundsPerSquareInch.format(it) })
        assertEquals("0.0mmHg", MillimetreMercury.of(0).let { MillimetreMercury.format(it) })
    }
}
