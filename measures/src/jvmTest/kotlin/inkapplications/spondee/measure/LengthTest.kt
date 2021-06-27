package inkapplications.spondee.measure

import inkapplications.spondee.assertConverts
import inkapplications.spondee.testConvert
import kotlin.test.Test

class LengthTest {
    @Test
    fun conversions() {
        testConvert(123, Meters) {
            equals(484_251.984, HundredthInches)
            equals(4_842_519.84, ThousandthInches)
            equals(4842.51984, Inches)
            equals(403.54332, Feet)
            equals(0.07642865909, Miles, 1e-8)
            equals(123.0, Meters)
        }

        assertConverts(Feet.of(1), Inches.of(12))
        assertConverts(Feet.of(1), HundredthInches.of(1200))
        assertConverts(Feet.of(1), ThousandthInches.of(12000))
        assertConverts(Feet.of(3), Yards.of(1))
        assertConverts(Feet.of(5280), Miles.of(1))
    }
}
