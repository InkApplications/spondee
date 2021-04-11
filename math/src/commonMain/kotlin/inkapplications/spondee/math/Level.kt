package inkapplications.spondee.math

import kotlin.math.absoluteValue
import kotlin.math.pow

/**
 * Unit of a ratio. Most commonly decibels.
 */
interface Level {
    /**
     * Express the level as a value in Bels.
     */
    val asBels: Double

    /**
     * Express the level as a value in Decibels.
     */
    val asDecibels: Double

    /**
     * +/- symbol for the level modifier.
     */
    val symbol: Char

    operator fun times(other: Number): Double
    operator fun plus(other: Level): Level
    operator fun unaryMinus(): Level
    operator fun unaryPlus(): Level = this
}

internal data class Bels(override val asBels: Double): Level {
    override val asDecibels get() = asBels * 10
    override val symbol: Char get() = if (asBels >= 0) '+' else '-'

    override operator fun times(other: Number): Double = 10.0.pow(asBels).times(other.toDouble())
    override operator fun plus(other: Level): Level = Bels(asBels + other.asBels)
    override fun unaryMinus() = Bels(-asBels)

    override fun toString(): String = "$symbol${asBels.absoluteValue}B"
}

internal data class Decibels(override val asDecibels: Double): Level {
    override val asBels get() = asDecibels / 10
    override val symbol: Char get() = if (asDecibels >= 0) '+' else '-'

    override operator fun times(other: Number): Double = 10.0.pow(asBels).times(other.toDouble())
    override operator fun plus(other: Level): Level = Bels(asBels + other.asBels)
    override fun unaryMinus() = Bels(-asDecibels)
    override fun toString(): String = "$symbol${asDecibels.absoluteValue}dB"
}

/**
 * Express a level in bels.
 */
val Number.bels: Level get() = Bels(toDouble())

/**
 * Express a level in decibels.
 */
val Number.decibels: Level get() = Decibels(toDouble())
