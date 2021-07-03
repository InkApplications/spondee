package inkapplications.spondee.measure

import inkapplications.spondee.testConvert
import kotlin.test.Test
import kotlin.test.assertEquals

class MassTest {
    @Test
    fun conversions() {
        testConvert(123, Grams) {
            equals(1898.18007741, Grains, 1e-8)
            equals(94.9090038705, Scruples, 1e-8)
            equals(69.4191571167, Drams, 1e-8)
            equals(4.33869731979, Ounces, 1e-8)
            equals(.27116858248, Pounds, 1e-8)
            equals(.00271168582, ShortHundredweights, 1e-6)
            equals(.00013558429, ShortTons, 1e-5)
            equals(.00012105740, LongTons, 1e-5)
            equals(0.000123, MetricTons)
        }
    }

    @Test
    fun format() {
        assertEquals("0.0g", Grams.of(0).let { Grams.format(it) })
        assertEquals("0.0scr", Scruples.of(0).let { Scruples.format(it) })
        assertEquals("0.0dr", Drams.of(0).let { Drams.format(it) })
        assertEquals("0.0oz", Ounces.of(0).let { Ounces.format(it) })
        assertEquals("0.0lbs", Pounds.of(0).let { Pounds.format(it) })
        assertEquals("0.0cwt", ShortHundredweights.of(0).let { ShortHundredweights.format(it) })
        assertEquals("0.0ST", ShortTons.of(0).let { ShortTons.format(it) })
        assertEquals("0.0LT", LongTons.of(0).let { LongTons.format(it) })
        assertEquals("0.0t", MetricTons.of(0).let { MetricTons.format(it) })
    }
}
