package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.toDimension
import inkapplications.spondee.structure.Kilo
import inkapplications.spondee.structure.per
import inkapplications.spondee.structure.scale
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds

/**
 * Express this number as a ratio of meters in a second
 */
val Number.metersPerSecond get() = meters per 1.seconds.toDimension()

/**
 * Express this number as a ratio of kilometers in an hour
 */
val Number.kilometersPerHour get() = scale(Kilo).meters per 1.hours.toDimension()
