package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline
import kotlin.math.pow

@JvmInline
value class Mass internal constructor(override val rawValue: Double): Measurement<Mass> {
    override val storedUnit: MeasurementUnit<Mass> get() = Grams
}

object Grams: BaseUnit<Mass>() {
    override fun of(value: Number): Mass = Mass(value.toDouble())
}

object Grains: MeasurementUnit<Mass> by Pounds * 7000
object Scruples: MeasurementUnit<Mass> by Pounds * 350
object Drams: MeasurementUnit<Mass> by Pounds * 256
object Ounces: MeasurementUnit<Mass> by Grams / 28.349_523_125
object Pounds: MeasurementUnit<Mass> by Ounces / 16
object ShortHundredweights: MeasurementUnit<Mass> by Pounds / 100
object ShortTons: MeasurementUnit<Mass> by Pounds / 2000
object LongTons: MeasurementUnit<Mass> by Pounds / 2240
object MetricTons: MeasurementUnit<Mass> by Grams / 1e6
