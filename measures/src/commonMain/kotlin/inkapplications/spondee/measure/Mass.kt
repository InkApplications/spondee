package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

@JvmInline
value class Mass internal constructor(override val rawValue: Double): DoubleMeasurement<Mass> {
    override val storedUnit: DoubleUnit<Mass> get() = Grams
}

object Grams: StoredUnit<Mass>() {
    override fun of(value: Number): Mass = Mass(value.toDouble())
}

object Grains: DoubleUnit<Mass> by Pounds * 7000
object Scruples: DoubleUnit<Mass> by Pounds * 350
object Drams: DoubleUnit<Mass> by Pounds * 256
object Ounces: DoubleUnit<Mass> by Grams / 28.349_523_125
object Pounds: DoubleUnit<Mass> by Ounces / 16
object ShortHundredweights: DoubleUnit<Mass> by Pounds / 100
object ShortTons: DoubleUnit<Mass> by Pounds / 2000
object LongTons: DoubleUnit<Mass> by Pounds / 2240
object MetricTons: DoubleUnit<Mass> by Grams / 1e6
