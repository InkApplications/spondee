package inkapplications.spondee.measure

import inkapplications.spondee.assertConverts
import inkapplications.spondee.testConvert
import kotlin.test.Test
import kotlin.test.assertEquals

class LengthTest {
    @Test
    fun conversions() {
        testConvert(123, Meters) {
            equals(484_251.984, HundredthInches)
            equals(4_842_519.84, ThousandthInches)
            equals(4842.51984, Inches)
            equals(403.54332, Feet)
            equals(134.51444, Yards)
            equals(0.07642865909, Miles, 1e-8)
            equals(123.0, Meters)
        }

        assertConverts(Feet.of(1), Inches.of(12))
        assertConverts(Feet.of(1), HundredthInches.of(1200))
        assertConverts(Feet.of(1), ThousandthInches.of(12000))
        assertConverts(Feet.of(3), Yards.of(1))
        assertConverts(Feet.of(5280), Miles.of(1))
    }

    @Test
    fun formats() {
        assertEquals("0.0m", Meters.of(0).let { Meters.format(it) })
        assertEquals("0.0(1/100)in", HundredthInches.of(0).let { HundredthInches.format(it) })
        assertEquals("0.0thou", ThousandthInches.of(0).let { ThousandthInches.format(it) })
        assertEquals("0.0in", Inches.of(0).let { Inches.format(it) })
        assertEquals("0.0ft", Feet.of(0).let { Feet.format(it) })
        assertEquals("0.0yd", Yards.of(0).let { Yards.format(it) })
        assertEquals("0.0mi", Miles.of(0).let { Miles.format(it) })
    }
}
