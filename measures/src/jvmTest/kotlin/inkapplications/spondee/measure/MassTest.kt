package inkapplications.spondee.measure

import kotlin.test.Test
import kotlin.test.assertEquals

class MassTest {
    @Test
    fun conversions() {
        assertEquals(0.27116858249, 123.grams.inPounds, 0.00000000001)
        assertEquals(55791.86151, 123.pounds.inGrams, 0.000001)
    }
}
