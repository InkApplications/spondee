package inkapplications.spondee.structure

import kotlin.test.Test
import kotlin.test.assertEquals

class DimensionScaleTest {
    @Test
    fun scale() {
        assertEquals(123_000.0, 123.scale(Kilo).toDouble(), 1e-15)
        assertEquals(0.123, 123.scale(Milli).toDouble(), 1e-15)
        assertEquals(123.0, 123.scale(Nominal).toDouble(), 1e-15)
    }
}
