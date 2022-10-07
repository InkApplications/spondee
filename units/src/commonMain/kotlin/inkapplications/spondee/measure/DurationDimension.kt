package inkapplications.spondee.measure

import inkapplications.spondee.structure.Dimension
import kotlin.jvm.JvmInline
import kotlin.time.Duration
import kotlin.time.Duration.Companion.nanoseconds

/**
 * Wraps a duration as a dimension for use in ratios.
 */
@JvmInline
value class DurationDimension(val duration: Duration): Dimension<DurationDimension> {
    override val value: Number get() = duration.inWholeNanoseconds
    override val symbol: String get() = "ns"
    override fun withValue(value: Number): DurationDimension = DurationDimension(value.toDouble().nanoseconds)
}

/**
 * Convert Kotlin's Duration unit into a dimension.
 */
fun Duration.toDimension() = DurationDimension(this)
