@file:OptIn(ExperimentalTime::class)
package inkapplications.spondee.measure

import inkapplications.spondee.structure.Ratio
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

typealias Speed = Ratio<Length, Duration>

val Ratio<Length, Duration>.inMilesPerHour get() = numerator.inMiles * denominator.toDouble(DurationUnit.HOURS)
val Ratio<Length, Duration>.inKilometersPerHour get() = numerator.inKilometers * denominator.toDouble(DurationUnit.HOURS)
val Ratio<Length, Duration>.inMetersPerSecond get() = numerator.inMeters * denominator.toDouble(DurationUnit.SECONDS)
