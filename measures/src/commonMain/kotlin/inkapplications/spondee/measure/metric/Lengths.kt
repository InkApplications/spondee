package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.Length
import inkapplications.spondee.structure.Dimension
import inkapplications.spondee.structure.Kilo
import inkapplications.spondee.structure.format
import inkapplications.spondee.structure.scale
import kotlin.jvm.JvmInline

/**
 * Metric length unit.
 */
@JvmInline
value class Meters(override val value: Number): Length, Dimension<Meters> {
    override fun toMeters(): Meters = this
    override val symbol: String get() = "m"
    override fun withValue(value: Number): Meters = Meters(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in meters
 */
val Number.meters get() = Meters(this)

/**
 * Convenience Reference dimension for a single meter
 */
val Meter = 1.meters

/**
 * Convenience getter to express a number as kilometers
 */
val Number.kilometers get() = 1.scale(Kilo).meters

/**
 * Convenience getter to express a number as centimeters
 */
val Number.centimeters get() = 1.scale(Kilo).meters
