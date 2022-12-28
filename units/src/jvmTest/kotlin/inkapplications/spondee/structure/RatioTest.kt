package inkapplications.spondee.structure

import kotlin.test.Test
import kotlin.test.assertEquals

class RatioTest {
    @Test
    fun testTransform() {
        assertEquals(ratioOf(1, 2), ratioOf(0, 2).transformNumerator { 1 })
        assertEquals(ratioOf(1, 2), ratioOf(1, 0).transformDenominator { 2 })
    }

    @Test
    fun calculatedValues() {
        assertEquals(.5, ratioOf(1, 2).value(), 1e-15)
        assertEquals(.5, ratioOf(TestDimension(1), 2).value(), 1e-15)
        assertEquals(.5, ratioOf(1, TestDimension(2)).value(), 1e-15)
        assertEquals(.5, ratioOf(TestDimension(1), TestDimension(2)).value(), 1e-15)
    }

    @Test
    fun testFormat() {
        val value = TestDimension(10) per TestDimension(2)

        assertEquals("5T/T", value.format())
        assertEquals("5000mT/T", value.format(numeratorScale = Milli))
        assertEquals("0kT/T", value.format(numeratorScale = Kilo))
        assertEquals("0.005kT/T", value.format(numeratorScale = Kilo, decimals = 3))
        assertEquals("5.0T/T", value.format(decimals = 1))
        assertEquals("5000T/kT", value.format(denominatorScale = Kilo))
        assertEquals("0T/mT", value.format(denominatorScale = Milli))
        assertEquals("0.005T/mT", value.format(denominatorScale = Milli, decimals = 3))
        assertEquals("0T/dT", value.format(denominatorScale = Deci, round = false))
        assertEquals("1T/dT", value.format(denominatorScale = Deci, round = true))
        assertEquals("1T/dT", value.format(denominatorScale = Deci, round = true))
        assertEquals("5", value.format(includeSymbols = false))
        assertEquals("5,0T/T", value.format(decimalSeparator = ',', decimals = 1))
    }
}
