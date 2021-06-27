package inkapplications.spondee.scalar

import inkapplications.spondee.structure.BaseUnit
import inkapplications.spondee.structure.Measurement
import inkapplications.spondee.structure.MeasurementUnit
import inkapplications.spondee.structure.times
import kotlin.jvm.JvmInline

@JvmInline
value class Percentage internal constructor(override val rawValue: Double): Measurement<Percentage> {
    override val storedUnit: MeasurementUnit<Percentage> get() = DecimalPercentage
}

object DecimalPercentage: BaseUnit<Percentage>() {
    override fun of(value: Number): Percentage = Percentage(value.toDouble())
}

object WholePercentage: MeasurementUnit<Percentage> by DecimalPercentage * 100
