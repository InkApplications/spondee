package inkapplications.spondee.measure

import org.junit.Test
import kotlin.test.assertEquals

class PressureTest {
    @Test
    fun conversions() {
        assertEquals(123.0, 123.pascals.inPascals.baseValue, 1e-5)
        assertEquals(.00123, 123.pascals.inBar.baseValue, 1e-10)
        assertEquals(0.01783964249, 123.pascals.inPsi, 1e-10)

        assertEquals(12300000.0, 123.bar.inPascals.baseValue, 1e-5)
        assertEquals(123.0, 123.bar.inBar.baseValue, 1e-10)
        assertEquals(1783.96424993, 123.bar.inPsi, 1e-8)

        assertEquals(848055.111, 123.psi.inPascals.baseValue, 1e-3)
        assertEquals(8.48055111, 123.psi.inBar.baseValue, 1e-10)
        assertEquals(123.0, 123.psi.inPsi, 1e-10)
    }
}
