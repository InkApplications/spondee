package inkapplications.spondee.measure

import kotlin.test.Test
import kotlin.test.assertEquals

class MassTest {
    @Test
    fun conversions() {
        assertEquals(0.27116858249, 123.grams.inPounds.decimal, 0.00000000001)
        assertEquals(55791.86151, 123.pounds.inGrams.baseValue, 0.000001)
        assertEquals(2, 2.5.pounds.inPounds.poundsComponent)
        assertEquals(8.0, 2.5.pounds.inPounds.ouncesComponent)
    }
}
