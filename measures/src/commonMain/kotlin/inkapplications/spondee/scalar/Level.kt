package inkapplications.spondee.scalar

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Unit of a relative ratio.
 */
interface Level {
    fun toBels(): Bels
}

/**
 * Metric ratio by power ratio.
 */
@JvmInline
value class Bels(override val value: Number): Level, Dimension<Bels> {
    override fun withValue(value: Number): Bels = Bels(value)
    override fun toBels(): Bels = this
    override val symbol: String get() = "B"
    override fun toString(): String = format()
}

/**
 * Express the current value as a unit in bels
 */
val Number.bels get() = Bels(this)

/**
 * Convenience getter for expressing a value in decibels.
 */
val Number.decibels get() = scale(Deci).bels
