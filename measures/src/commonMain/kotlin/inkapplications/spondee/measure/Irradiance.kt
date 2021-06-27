package inkapplications.spondee.measure

import inkapplications.spondee.structure.StoredUnit
import inkapplications.spondee.structure.DoubleMeasurement
import inkapplications.spondee.structure.DoubleUnit
import kotlin.jvm.JvmInline

/**
 * Power per unit area.
 */
@JvmInline
value class Irradiance internal constructor(override val rawValue: Double): DoubleMeasurement<Irradiance> {
    override val storedUnit: DoubleUnit<Irradiance> get() = WattsPerSquareMeter
}

object WattsPerSquareMeter: StoredUnit<Irradiance>() {
    override fun of(value: Number): Irradiance = Irradiance(value.toDouble())
}
