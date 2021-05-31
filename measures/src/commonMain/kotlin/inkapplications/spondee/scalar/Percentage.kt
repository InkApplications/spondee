package inkapplications.spondee.scalar

import kotlin.jvm.JvmInline

/**
 * Represents a percentage value.
 */
interface Percentage {
    /**
     * Express the percentage as a fractional value.
     *
     * ie. 50% will be `0.5`
     */
    val fraction: Double

    /**
     * Express the percentage as a whole value.
     *
     * ie. 50% will be `50.0`
     */
    val whole: Double

    operator fun times(other: Number): Double = fraction.times(other.toDouble())
    operator fun div(other: Number): Double = fraction.div(other.toDouble())
    operator fun rem(other: Number) = fraction.rem(other.toDouble())
    operator fun plus(other: Percentage): Percentage
    operator fun minus(other: Percentage): Percentage
    operator fun compareTo(other: Percentage): Int
    operator fun unaryPlus(): Percentage = this
    operator fun unaryMinus(): Percentage
    operator fun inc(): Percentage = plus(1.percent)
    operator fun dec(): Percentage = minus(1.percent)

    /**
     * Shorthand readable syntax for multiplying.
     *
     * ex:
     *     50.percent of 100
     */
    infix fun of(other: Number) = times(other)
}

/**
 * Store a percentage as a fractional backed value.
 */
@JvmInline
internal value class FractionalPercentage(override val fraction: Double): Percentage {
    override val whole: Double get() = fraction * 100

    override operator fun plus(other: Percentage): Percentage = FractionalPercentage(fraction + other.fraction)
    override operator fun minus(other: Percentage): Percentage = FractionalPercentage(fraction - other.fraction)
    override operator fun compareTo(other: Percentage): Int = fraction.compareTo(other.fraction)
    override operator fun unaryMinus() = FractionalPercentage(-fraction)

    override fun toString(): String = "$whole%"
}

/**
 * Store a percentage as a whole backed value.
 *
 * This is fairly equivalent to a [FractionalPercentage] but allows us to not
 * modify the value at all.
 */
@JvmInline
internal value class WholePercentage(override val whole: Double): Percentage {
    override val fraction: Double get() = whole / 100

    override operator fun plus(other: Percentage): Percentage = WholePercentage(whole + other.whole)
    override operator fun minus(other: Percentage): Percentage = WholePercentage(whole - other.whole)
    override operator fun compareTo(other: Percentage): Int = whole.compareTo(other.whole)
    override operator fun unaryMinus() = WholePercentage(-whole)

    override fun toString(): String = "$whole%"
}

/**
 * Express a percentage as a whole number.
 *
 * This is a whole number, not a fraction!
 * ex. `55.percent` is 55% or 0.55
 *
 * @see asPercentage to convert a fractional value such as `.55`
 */
val Number.percent: Percentage get() = WholePercentage(toDouble())

/**
 * Express with a fractional percentage.
 *
 * This is a fraction value, not a whole percentage!
 * ex: `0.55f.asPercentage` is 55%
 *
 * @see percent to convert a whole percentage value.
 */
val Float.asPercentage: Percentage get() = FractionalPercentage(toDouble())

/**
 * Express with a fractional percentage.
 *
 * This is a fraction value, not a whole percentage!
 * ex: `0.55f.asPercentage` is 55%
 *
 * @see percent to convert a whole percentage value.
 */
val Double.asPercentage: Percentage get() = FractionalPercentage(this)
