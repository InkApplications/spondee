package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Unit of force applied over an area.
 */
@JvmInline
value class Pressure internal constructor(override val rawValue: Double): Measurement<Pressure> {
    override val storedUnit: MeasurementUnit<Pressure> get() = Pascals
}

/**
 * SI Base Unit of Pressure.
 */
object Pascals: BaseUnit<Pressure>() {
    override fun of(value: Number): Pressure = Pressure(value.toDouble())
}

object Bar: MeasurementUnit<Pressure> by Pascals * 1e-5
object PoundsPerSquareInch: MeasurementUnit<Pressure> by Pascals * 0.000_145_037_74
object MillimetreMercury: MeasurementUnit<Pressure> by Pascals * 0.007_500_615

typealias Psi = PoundsPerSquareInch
