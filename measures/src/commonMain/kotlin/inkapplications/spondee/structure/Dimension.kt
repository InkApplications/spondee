package inkapplications.spondee.structure

import inkapplications.spondee.format.formatDecimal

/**
 * A concrete dimension value.
 */
interface Dimension<T>: Symbolized {
    /**
     * Raw value of the dimension.
     */
    val value: Number

    /**
     * Copy this dimension to change the value.
     */
    fun withValue(value: Number): T
}

/**
 * Get the value of a dimension, with parameters
 *
 * @param scale A scalar value to get the value as.
 *     eg. `1.meter.value(scale = Kilo) // returns .001`
 */
fun Dimension<*>.value(scale: DimensionScale = Nominal): Number = value.toDouble().div(scale.factor.toDouble())

operator fun <T: Dimension<T>> T.plus(other: Number) = value.toDouble().plus(other.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.minus(other: Number) = value.toDouble().minus(other.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.rem(other: Number) = value.toDouble().rem(other.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.times(other: Number) = value.toDouble().times(other.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.div(other: Number) = value.toDouble().div(other.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.compareTo(other: Number) = value.toDouble().compareTo(other.toDouble())

operator fun <T: Dimension<T>> T.plus(other: T) = value.toDouble().plus(other.value.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.minus(other: T) = value.toDouble().minus(other.value.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.rem(other: T) = value.toDouble().rem(other.value.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.times(other: T) = value.toDouble().times(other.value.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.div(other: T) = value.toDouble().div(other.value.toDouble()).let(::withValue)
operator fun <T: Dimension<T>> T.compareTo(other: T) = value.toDouble().compareTo(other.value.toDouble())

inline fun <T: Dimension<T>, R> T.convert(transform: Double.() -> R): R {
    return value.toDouble().run(transform)
}

/**
 * Format a dimension's value as a string.
 *
 * @param scale The scale to display the number in.
 * @param decimals The number of decimal places to display.
 * @param round Whether to round the decimal, otherwise it will be floored.
 * @param includeSymbols Whether to append the dimension and scale's unit symbols in the string output.
 * @param decimalSeparator The separation character for the decimal point.
 * @return A string representation of the number, with the decimal formatted.
 */
fun <T: Dimension<*>> T.format(
    scale: DimensionScale = Nominal,
    decimals: Int = 0,
    round: Boolean = true,
    includeSymbols: Boolean = true,
    decimalSeparator: Char = '.',
): String {
    return value(scale = scale).formatDecimal(
        decimals = decimals,
        round = round,
        decimalSeparator = decimalSeparator,
    ).let { "$it${scale.prefix}${(this as? Symbolized)?.symbol?.takeIf { includeSymbols }.orEmpty()}" }
}
