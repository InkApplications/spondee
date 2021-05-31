package inkapplications.spondee.measure

import org.junit.Test
import kotlin.test.assertEquals

class PressureTest {
    @Test
    fun conversions() {
        assertEquals(123.0, 123.pascals.inPascals, .0001)
        assertEquals(.00123, 123.pascals.inBar, .000001)
        assertEquals(.01784, 123.pascals.inPsi, .00001)

        assertEquals(12300000.0, 123.bar.inPascals, .0001)
        assertEquals(123.0, 123.bar.inBar, .000001)
        assertEquals(1783.96371, 123.bar.inPsi, .000001)

        assertEquals(848055.14, 123.psi.inPascals, .01)
        assertEquals(8.48055, 123.psi.inBar, .00001)
        assertEquals(123.0, 123.psi.inPsi, .000001)
    }
}
