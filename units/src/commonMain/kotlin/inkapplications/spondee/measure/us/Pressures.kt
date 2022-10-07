package inkapplications.spondee.measure.us

import inkapplications.spondee.measure.Pressure
import inkapplications.spondee.measure.metric.Pascals
import inkapplications.spondee.measure.metric.pascals
import inkapplications.spondee.structure.Dimension
import inkapplications.spondee.structure.format
import inkapplications.spondee.structure.convert
import kotlin.jvm.JvmInline

private const val PSI_PER_PASCAL = 0.000_145_037_74

/**
 * US Customary unit of pressure as a ratio of pounds per square inch.
 */
@JvmInline
value class PoundsPerSquareInch(override val value: Number): Pressure, Dimension<PoundsPerSquareInch> {
    override val symbol: String get() = "psi"
    override fun toPascals(): Pascals = convert { this / PSI_PER_PASCAL }.pascals
    override fun withValue(value: Number): PoundsPerSquareInch = PoundsPerSquareInch(value)

    override fun toString(): String = format()
}

/**
 * Express this number as a unit of pressure in pounds per square inch
 */
val Number.poundsPerSquareInch get() = PoundsPerSquareInch(this)

/**
 * Convenience getter for [poundsPerSquareInch]
 */
val Number.psi get() = poundsPerSquareInch

/**
 * Convert a unit of pressure to pounds per square inches
 */
fun Pressure.toPoundsPerSquareInch() = toPascals().convert { this * PSI_PER_PASCAL }.poundsPerSquareInch

/**
 * Convenience method for [toPounds]
 */
fun Pressure.toPsi() = toPoundsPerSquareInch()

/**
 * Convenience unit for a single pound per square inch
 */
val PoundPerSquareInch = 1.poundsPerSquareInch

/**
 * Convenience alias for [PoundPerSquareInch]
 */
val PSI = 1.psi
