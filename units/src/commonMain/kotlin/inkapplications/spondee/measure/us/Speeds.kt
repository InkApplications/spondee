package inkapplications.spondee.measure.us

import inkapplications.spondee.measure.Speed
import inkapplications.spondee.measure.toDimension
import inkapplications.spondee.structure.per
import inkapplications.spondee.structure.value
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

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
