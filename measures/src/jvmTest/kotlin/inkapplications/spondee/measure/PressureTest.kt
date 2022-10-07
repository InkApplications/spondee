package inkapplications.spondee.measure

import inkapplications.spondee.assertEquals
import inkapplications.spondee.measure.metric.*
import inkapplications.spondee.measure.us.psi
import inkapplications.spondee.measure.us.toPsi
import inkapplications.spondee.withExpectation
import org.junit.Test
import kotlin.test.assertEquals

class PressureTest {
    @Test
    fun conversions() {
        with(123.pascals) {
            assertEquals(.00123, toBar().value.toDouble(), 1e-15)
            assertEquals(0.01783964202, toPsi().value.toDouble(), 1e-15)
            assertEquals(0.922575645, toMillimetreMercury().value.toDouble(), 1e-15)
        }
        withExpectation(123.pascals) {
            assertEquals(.00123.bar.toPascals(), 1e-10)
            assertEquals(0.01783964202.psi.toPascals(), 1e-10)
            assertEquals(0.922575645.mmHg.toPascals(), 1e-10)
        }
    }

    @Test
    fun formats() {
        assertEquals("0Pa", 0.pascals.toString())
        assertEquals("0bar", 0.bar.toString())
        assertEquals("0psi", 0.psi.toString())
        assertEquals("0mmHg", 0.mmHg.toString())
    }
}
