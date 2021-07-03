package inkapplications.spondee.scalar

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

@JvmInline
value class Percentage internal constructor(override val rawValue: Double): DoubleMeasurement<Percentage> {
    override val storedUnit: DoubleUnit<Percentage> get() = DecimalPercentage
}

object DecimalPercentage: StoredUnit<Percentage>(
    symbol = ""
) {
    override fun of(value: Number): Percentage = Percentage(value.toDouble())
}

object WholePercentage: DerivedUnit<Percentage>(
    definition = DecimalPercentage * 100,
    symbol = "%",
)
