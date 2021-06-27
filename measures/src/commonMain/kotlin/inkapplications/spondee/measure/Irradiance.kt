package inkapplications.spondee.measure

import inkapplications.spondee.structure.BaseUnit
import inkapplications.spondee.structure.Measurement
import inkapplications.spondee.structure.MeasurementUnit
import kotlin.jvm.JvmInline

/**
 * Power per unit area.
 */
@JvmInline
value class Irradiance internal constructor(override val baseValue: Double): Measurement<Irradiance> {
    override val baseUnit: MeasurementUnit<Irradiance> get() = WattsPerSquareMeter
}

object WattsPerSquareMeter: BaseUnit<Irradiance>() {
    override fun of(value: Number): Irradiance = Irradiance(value.toDouble())
}
