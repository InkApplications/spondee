package inkapplications.spondee.structure

import kotlin.test.Test
import kotlin.test.assertEquals

class DimensionTest {
    @Test
    fun valueScale() {
        assertEquals(.001, TestDimension(1).value(scale = Kilo).toDouble(), 1e-15)
        assertEquals(1000.0, TestDimension(1).value(scale = Milli).toDouble(), 1e-15)
        assertEquals(1.0, TestDimension(1).value().toDouble(), 1e-15)
    }

    @Test
    fun math() {
        assertEquals(TestDimension(5.0), TestDimension(2) + 3)
        assertEquals(TestDimension(6.0), TestDimension(8) - 2)
        assertEquals(TestDimension(8.0), TestDimension(4) * 2)
        assertEquals(TestDimension(4.0), TestDimension(8) / 2)
        assertEquals(TestDimension(1.0), TestDimension(5) % 4)
    }
}

