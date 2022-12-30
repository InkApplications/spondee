package inkapplications.spondee.measure.us

import inkapplications.spondee.measure.DurationDimension
import inkapplications.spondee.measure.Length
import inkapplications.spondee.measure.Speed
import inkapplications.spondee.measure.metric.meters
import inkapplications.spondee.measure.toDimension
import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

private const val METERS_PER_NAUTICAL_MILE = 1852.0

/**
 * Unit of speed in Nautical Miles Per Hour.
 */
@JvmInline
value class Knots(override val value: Number): Speed, Dimension<Knots> {
    override val denominator: DurationDimension get() = 1.hours.toDimension()
    override val numerator: Length get() = (value.toDouble() * METERS_PER_NAUTICAL_MILE).meters

    override fun <T> transformNumerator(transform: (Length) -> T): Ratio<T, DurationDimension> {
        return transform(numerator) per denominator
    }
    override fun <T> transformDenominator(transform: (DurationDimension) -> T): Ratio<Length, T> {
        return numerator per transform(denominator)
    }
    override fun withValue(value: Number): Knots = Knots(value)
    override val symbol: String get() = "kn"
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in knots
 */
val Number.knots get() = Knots(this)

/**
 * Convenience reference dimension for a single knot
 */
val Knot = 1.knots

/**
 * Convert this dimension to Knots
 */
fun Speed.toKnots(): Knots = numerator.toMeters()
    .toDouble()
    .div(METERS_PER_NAUTICAL_MILE)
    .div(denominator.duration.toDouble(DurationUnit.HOURS))
    .knots


/**
 * Express this number as a speed ratio of feet per second
 */
val Number.feetPerSecond get() = feet per 1.seconds.toDimension()

/**
 * Calculate the value in feet per second.
 */
fun Speed.toFeetPerSecondValue() = transformNumerator { it.toFeet() }
    .transformDenominator { it.duration.toDouble(DurationUnit.SECONDS) }
    .value()

/**
 * Express this number as a speed ratio in miles per hour
 */
val Number.milesPerHour get() = miles per 1.hours.toDimension()

/**
 * Calculate the value in miles per hour.
 */
fun Speed.toMilesPerHourValue() = transformNumerator { it.toMiles() }
    .transformDenominator { it.duration.toDouble(DurationUnit.HOURS) }
    .value()
