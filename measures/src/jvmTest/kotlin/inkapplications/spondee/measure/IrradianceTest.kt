package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Meter
import inkapplications.spondee.measure.metric.watts
import inkapplications.spondee.measure.us.toFeet
import inkapplications.spondee.structure.*
import kotlin.test.Test
import kotlin.test.assertEquals

class IrradianceTest {
    @Test
    fun resolveCalculations() {
        assertEquals(123.0, (123.watts per Square(Meter)).value().toDouble())

        val wattsPerSquareFeet = (123.watts per Square(Meter)).transformNumerator { it.toWatts() }
            .transformDenominator { Square(it.value.toFeet()) }

        assertEquals(11.427073, wattsPerSquareFeet.value().toDouble(), 1e-6)
    }

    @Test
    fun format() {
        assertEquals("123W/m^2", (123.watts per Square(Meter)).format())
        val convertedResult = (123.watts per Square(Meter))
            .transformNumerator { it.toWatts() }
            .transformDenominator { Square(it.value.toFeet()) }
            .format(decimals = 2)
        assertEquals("11.43W/ft^2", convertedResult)
    }
}
