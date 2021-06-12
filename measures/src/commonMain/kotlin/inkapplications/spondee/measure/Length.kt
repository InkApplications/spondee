package inkapplications.spondee.measure

import inkapplications.spondee.structure.DoubleMeasure
import inkapplications.spondee.structure.SiValue
import kotlin.jvm.JvmInline

private const val FEET_PER_METER = 3.280_840
private const val FEET_PER_YARD = 3.0
private const val INCHES_PER_FOOT = 12.0
private const val FEET_PER_MILE = 5280.0

/**
 * Unit of measurement for a length/distance.
 */
interface Length: DoubleMeasure<Length> {
    /**
     * Express a length as a value as an SI base Unit of meters.
     */
    val inMeters: SiValue

    /**
     * Express a length as a value as an SI base Unit of meters.
     */
    val inFeet: Double

    /**
     * Express a length as a value in thousandths of inches.
     */
    val inThou: Double get() = inInches * 1000.0

    /**
     * Express a length as a value in hundredths of inches.
     */
    val inHundredthsOfInches: Double get() = inInches * 100.0

    /**
     * Express a length as a value in inches.
     */
    val inInches: Double get() = inFeet * INCHES_PER_FOOT

    /**
     * Express a length as a value in Yards.
     */
    val inYards: Double get() = inFeet / FEET_PER_YARD

    /**
     * Express a length as a value in Miles
     */
    val inMiles: Double get() = inFeet / FEET_PER_MILE
}

@JvmInline
internal value class Meters(override val inMeters: SiValue): Length {
    override val inFeet: Double get() = inMeters.baseValue * FEET_PER_METER

    override fun convert(value: Length): Double = value.inMeters.baseValue
    override fun create(value: Double): Length = value.meters

    override fun toString(): String = "${inMeters}m"
}

/**
 * Express a number as a length in Meters.
 */
val Number.meters: Length get() = Meters(SiValue(toDouble()))

/**
 * Express a converted SI Value as a length in a base unit of Meters.
 */
val SiValue.meters: Length get() = Meters(this)

@JvmInline
internal value class Feet(override val inFeet: Double): Length {
    override val inMeters get() = SiValue(inFeet / FEET_PER_METER)

    override fun convert(value: Length): Double = value.inFeet
    override fun create(value: Double): Length = Feet(value)

    override fun toString(): String = when {
        inFeet < 1 -> "${inInches}in"
        inFeet >= FEET_PER_MILE -> "${inMiles}mi"
        else -> "${inFeet}ft"
    }
}

/**
 * Express a number as a length in miles.
 */
val Number.miles: Length get() = Feet(toDouble() * FEET_PER_MILE)

/**
 * Express a number as a length in yards.
 */
val Number.yards: Length get() = Feet(toDouble() * FEET_PER_YARD)

/**
 * Express a number as a length in feet.
 */
val Number.feet: Length get() = Feet(toDouble())

/**
 * Express a number as a length in inches.
 */
val Number.inches: Length get() = Feet(toDouble() / INCHES_PER_FOOT)

/**
 * Express a number as a length in hundredths of inches.
 */
val Number.hundredthsOfInches: Length get() = Feet(toDouble() / 100.0 / INCHES_PER_FOOT)

/**
 * Express a number as a length in thousandths of inches.
 */
val Number.thou: Length get() = Feet(toDouble() / 1000.0 / INCHES_PER_FOOT)
