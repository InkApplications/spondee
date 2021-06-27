package inkapplications.spondee.measure

import inkapplications.spondee.structure.BaseUnit
import inkapplications.spondee.structure.Measurement
import inkapplications.spondee.structure.MeasurementUnit
import kotlin.jvm.JvmInline

/**
 * Unit of energy per unit time
 */
@JvmInline
value class Power internal constructor(override val rawValue: Double): Measurement<Power> {
    override val storedUnit: MeasurementUnit<Power> get() = Watts
}

object Watts: BaseUnit<Power>() {
    override fun of(value: Number): Power = Power(value.toDouble())
}
