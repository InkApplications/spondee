package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Unit of force applied over an area.
 */
@JvmInline
value class Pressure internal constructor(override val rawValue: Double): DoubleMeasurement<Pressure> {
    override val storedUnit: DoubleUnit<Pressure> get() = Pascals
}

/**
 * SI Base Unit of Pressure.
 */
object Pascals: StoredUnit<Pressure>() {
    override fun of(value: Number): Pressure = Pressure(value.toDouble())
}

object Bar: DoubleUnit<Pressure> by Pascals * 1e-5
object PoundsPerSquareInch: DoubleUnit<Pressure> by Pascals * 0.000_145_037_74
object MillimetreMercury: DoubleUnit<Pressure> by Pascals * 0.007_500_615

typealias Psi = PoundsPerSquareInch
