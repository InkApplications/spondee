package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.Speed
import inkapplications.spondee.measure.toDimension
import inkapplications.spondee.structure.Kilo
import inkapplications.spondee.structure.per
import inkapplications.spondee.structure.scale
import inkapplications.spondee.structure.value
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

/**
 * Express this number as a ratio of meters in a second
 */
val Number.metersPerSecond get() = meters per 1.seconds.toDimension()

/**
 * Calculate the value in meters per second.
 */
fun Speed.toMetersPerSecondValue() = transformNumerator { it.toMeters() }
    .transformDenominator { it.duration.toDouble(DurationUnit.SECONDS) }
    .value()

/**
 * Express this number as a ratio of kilometers in an hour
 */
val Number.kilometersPerHour get() = scale(Kilo).meters per 1.hours.toDimension()

/**
 * Calculate the value in meters per second.
 */
fun Speed.toKilometersPerHourValue() = transformNumerator { it.toMeters() }
    .transformDenominator { it.duration.toDouble(DurationUnit.HOURS) }
    .value(Kilo)
