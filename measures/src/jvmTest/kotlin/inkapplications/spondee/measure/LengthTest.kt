package inkapplications.spondee.measure

import kotlin.test.Test
import kotlin.test.assertEquals

class LengthTest {
    @Test
    fun conversions() {
        123.feet.run {
            assertEquals(147_600.0, inHundredthsOfInches, 1e-10)
            assertEquals(1476_000.0, inThou, 1e-10)
            assertEquals(1476.0, inInches, 1e-10)
            assertEquals(123.0, inFeet, 1e-10)
            assertEquals(0.02329545454, inMiles, 1e-10)

            assertEquals(37.4903988003, inMeters.baseValue, 1e-10)
        }

        123.meters.run {
            assertEquals(484_251.984, inHundredthsOfInches, 1e-10)
            assertEquals(4_842_519.84, inThou, 1e-10)
            assertEquals(4842.51984, inInches, 1e-10)
            assertEquals(403.54332, inFeet, 1e-10)
            assertEquals(0.07642865909, inMiles, 1e-10)

            assertEquals(123.0, inMeters.baseValue, 1e-10)
        }

        assertEquals(1.feet, 12.inches)
        assertEquals(1.feet, 1200.hundredthsOfInches)
        assertEquals(1.feet, 12000.thou)
        assertEquals(5280.feet, 1.miles)
    }
}
