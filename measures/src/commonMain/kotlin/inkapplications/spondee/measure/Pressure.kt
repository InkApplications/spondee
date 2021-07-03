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
object Pascals: StoredUnit<Pressure>(
    symbol = "Pa"
) {
    override fun of(value: Number): Pressure = Pressure(value.toDouble())
}

object Bar: DerivedUnit<Pressure>(
    definition = Pascals * 1e-5,
    symbol = "bar",
)
object PoundsPerSquareInch: DerivedUnit<Pressure>(
    definition = Pascals * 0.000_145_037_74,
    symbol = "psi",
)
object MillimetreMercury: DerivedUnit<Pressure>(
    definition = Pascals * 0.007_500_615,
    symbol = "mmHg",
)

typealias Psi = PoundsPerSquareInch
