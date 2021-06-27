package inkapplications.spondee.measure

import inkapplications.spondee.testConvert
import kotlin.test.Test

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
}
