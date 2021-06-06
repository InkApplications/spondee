package inkapplications.spondee.structure

import inkapplications.spondee.measure.A
import inkapplications.spondee.measure.B
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DoubleMeasureTest {
    @Test
    fun math() {
        val a = A(123.0)
        val b = B(432.0)

        assertEquals(a, +a)
        assertEquals(-123.0, (-a).value)
        assertEquals(15129.0, a.pow(2).value)
        assertTrue(a > A(0.0))
        assertTrue(A(0.0) < a)
        assertEquals(124.0, (a + A(1.0)).value)
        assertEquals(122.0, (a - A(1.0)).value)
        assertEquals(61.5, (a / 2).value)
        assertEquals(246.0, (a * 2).value)
        assertEquals(Product(a, b), a * b)
    }
}
