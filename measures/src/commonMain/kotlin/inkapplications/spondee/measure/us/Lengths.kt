package inkapplications.spondee.measure.us

import inkapplications.spondee.measure.Length
import inkapplications.spondee.measure.metric.Meters
import inkapplications.spondee.measure.metric.meters
import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Ratio of feet:meters for conversions
 */
private const val FEET_PER_METER = 3.280_840

/**
 * US Customary Feet unit.
 */
@JvmInline
value class Feet(override val value: Number): Length, Dimension<Feet> {
    override val symbol: String get() = "ft"
    override fun toMeters(): Meters = value.toDouble().div(FEET_PER_METER).meters
    override fun withValue(value: Number): Feet = Feet(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in feet.
 */
val Number.feet get() = Feet(this)

/**
 * Convert this dimension to feet
 */
fun Length.toFeet(): Feet = toMeters().times(FEET_PER_METER).value.feet

/**
 * Convenience reference dimension for a single foot.
 */
val Foot = 1.feet

/**
 * Ratio of feet:miles used in conversions
 */
private const val FEET_PER_MILE = 5280

/**
 * US Customary  Miles unit
 */
@JvmInline
value class Miles(override val value: Number): Length, Dimension<Miles> {
    override val symbol: String get() = "mi"
    override fun toMeters(): Meters = value.toDouble().times(FEET_PER_MILE).feet.toMeters()
    override fun withValue(value: Number): Miles = Miles(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in miles
 */
val Number.miles get() = Miles(this)

/**
 * Convert a length to a unit of miles
 */
fun Length.toMiles(): Miles = Miles(toFeet().value.toDouble() / FEET_PER_MILE)

/**
 * Convenience reference unit for a single mile
 */
val Mile = 1.miles

/**
 * US Customary Yard unit.
 */
@JvmInline
value class Yards(override val value: Number): Length, Dimension<Yards> {
    override val symbol: String get() = "yd"
    override fun toMeters(): Meters = value.toDouble().times(3).feet.toMeters()
    override fun withValue(value: Number): Yards = Yards(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in Yards
 */
val Number.yards get() = Yards(this)

/**
 * Convert a length to a unit of yards
 */
fun Length.toYards(): Yards = Yards(toFeet().value.toDouble() / 3)

/**
 * Convenience reference unit for a single yard
 */
val Yard = 1.yards

/**
 * US Customary Inches unit
 */
@JvmInline
value class Inches(override val value: Number): Length, Dimension<Inches> {
    override val symbol: String get() = "in"
    override fun toMeters(): Meters = convert { feet / 12 }.toMeters()
    override fun withValue(value: Number): Inches = Inches(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in inches
 */
val Number.inches get() = Inches(this)

/**
 * Convert a length to a unit of inches
 */
fun Length.toInches() = toFeet().convert { this * 12 }.inches

/**
 * Convenience reference unit for a single inch
 */
val Inch = 1.inches

/**
 * Convenience getter for a value in thousandths of inches
 */
val Number.thou get() = scale(Thou).inches
