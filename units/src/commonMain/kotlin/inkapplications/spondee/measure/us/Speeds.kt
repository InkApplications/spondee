package inkapplications.spondee.measure.us

import inkapplications.spondee.measure.toDimension
import inkapplications.spondee.structure.per
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds

/**
 * Express this number as a speed ratio of feet per second
 */
val Number.feetPerSecond get() = feet per 1.seconds.toDimension()

/**
 * Express this number as a speed ratio in miles per hour
 */
val Number.milesPerHour get() = miles per 1.hours.toDimension()
