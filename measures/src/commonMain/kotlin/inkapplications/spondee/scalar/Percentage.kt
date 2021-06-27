package inkapplications.spondee.scalar

import inkapplications.spondee.structure.StoredUnit
import inkapplications.spondee.structure.DoubleMeasurement
import inkapplications.spondee.structure.DoubleUnit
import inkapplications.spondee.structure.times
import kotlin.jvm.JvmInline

@JvmInline
value class Percentage internal constructor(override val rawValue: Double): DoubleMeasurement<Percentage> {
    override val storedUnit: DoubleUnit<Percentage> get() = DecimalPercentage
}

object DecimalPercentage: StoredUnit<Percentage>() {
    override fun of(value: Number): Percentage = Percentage(value.toDouble())
}

object WholePercentage: DoubleUnit<Percentage> by DecimalPercentage * 100
