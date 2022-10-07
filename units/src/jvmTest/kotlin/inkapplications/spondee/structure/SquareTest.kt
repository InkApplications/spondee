package inkapplications.spondee.structure

import kotlin.test.Test
import kotlin.test.assertEquals

class SquareTest {
    @Test
    fun strings() {
        assertEquals("(4T)^2", Square(TestDimension(4)).toString())
        assertEquals("4T^2", Square(TestDimension(4)).format())
    }
}
