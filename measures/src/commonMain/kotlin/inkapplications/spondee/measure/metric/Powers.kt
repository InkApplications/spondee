package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.Power
import inkapplications.spondee.structure.Dimension
import kotlin.jvm.JvmInline

/**
 * Metric unit of power
 */
@JvmInline
value class Watts(override val value: Number): Power, Dimension<Watts> {
    override fun withValue(value: Number): Watts = Watts(value)
    override fun toWatts(): Watts = this
    override val symbol: String get() = "W"
}

/**
 * Express this number as a power unit in watts
 */
val Number.watts: Watts get() = Watts(this)

/**
 * Convenience reference dimension for a single watt.
 */
val Watt = 1.watts
