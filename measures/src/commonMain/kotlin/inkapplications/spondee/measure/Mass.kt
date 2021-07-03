package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

@JvmInline
value class Mass internal constructor(override val rawValue: Double): DoubleMeasurement<Mass> {
    override val storedUnit: DoubleUnit<Mass> get() = Grams
}

object Grams: StoredUnit<Mass>(
    symbol = "g"
) {
    override fun of(value: Number): Mass = Mass(value.toDouble())
}

object Grains: DerivedUnit<Mass>(
    definition = Pounds * 7000,
    symbol = "gr",
)
object Scruples: DerivedUnit<Mass>(
    definition = Pounds * 350,
    symbol = "scr",
)
object Drams: DerivedUnit<Mass>(
    definition = Pounds * 256,
    symbol = "dr",
)
object Ounces: DerivedUnit<Mass>(
    definition = Grams / 28.349_523_125,
    symbol = "oz",
)
object Pounds: DerivedUnit<Mass>(
    definition = Ounces / 16,
    symbol = "lbs",
)
object ShortHundredweights: DerivedUnit<Mass>(
    definition = Pounds / 100,
    symbol = "cwt",
)
object ShortTons: DerivedUnit<Mass>(
    definition = Pounds / 2000,
    symbol = "ST",
)
object LongTons: DerivedUnit<Mass>(
    definition = Pounds / 2240,
    symbol = "LT",
)
object MetricTons: DerivedUnit<Mass>(
    definition = Grams / 1e6,
    symbol = "t",
)
