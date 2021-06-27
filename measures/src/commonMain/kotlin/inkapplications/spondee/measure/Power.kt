package inkapplications.spondee.measure

import inkapplications.spondee.structure.StoredUnit
import inkapplications.spondee.structure.DoubleMeasurement
import inkapplications.spondee.structure.DoubleUnit
import kotlin.jvm.JvmInline

/**
 * Unit of energy per unit time
 */
@JvmInline
value class Power internal constructor(override val rawValue: Double): DoubleMeasurement<Power> {
    override val storedUnit: DoubleUnit<Power> get() = Watts
}

object Watts: StoredUnit<Power>() {
    override fun of(value: Number): Power = Power(value.toDouble())
}
