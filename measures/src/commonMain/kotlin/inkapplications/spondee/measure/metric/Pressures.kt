package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.Pressure
import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * SI base unit Metric unit of Pressure.
 */
@JvmInline
value class Pascals(override val value: Number): Pressure, Dimension<Pascals> {
    override val symbol: String get() = "Pa"
    override fun toPascals(): Pascals = this
    override fun withValue(value: Number): Pascals = Pascals(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a pressure unit in Pascals
 */
val Number.pascals get() = Pascals(this)

/**
 * Convenience reference unit for a single pascal
 */
val Pascal = 1.pascals

/**
 * Alternate Metric pressure unit of Bars.
 */
@JvmInline
value class Bar(override val value: Number): Pressure, Dimension<Bar> {
    override val symbol: String get() = "bar"
    override fun toPascals(): Pascals = convert { this / 1e-5 }.pascals
    override fun withValue(value: Number): Bar = Bar(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a pressure unit in Bar
 */
val Number.bar get() = Bar(this)

/**
 * Convert a pressure unit to a unit in Bar.
 */
fun Pressure.toBar() = toPascals().convert { this * 1e-5 }.bar

private const val MMHG_PER_PASCAL = 0.007_500_615

/**
 * Alternate Metric pressure units in millimeters of mercury.
 */
@JvmInline
value class MillimetreMercury(override val value: Number): Pressure, Dimension<MillimetreMercury> {
    override val symbol: String get() = "mmHg"
    override fun toString(): String = format()
    override fun toPascals(): Pascals = convert { pascals / MMHG_PER_PASCAL }
    override fun withValue(value: Number): MillimetreMercury = MillimetreMercury(value)
}

/**
 * Express this number as a pressure unit in millimeters of mercury.
 */
val Number.millimetreMercury get() = MillimetreMercury(this)

/**
 * Convenience alias for [millimetreMercury]
 */
val Number.mmHg get() = millimetreMercury

/**
 * Convert a pressure unit to millimeters of mercury
 */
fun Pressure.toMillimetreMercury() = toPascals().convert { this * MMHG_PER_PASCAL }.millimetreMercury
