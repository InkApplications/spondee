package inkapplications.spondee.structure

import inkapplications.spondee.format.formatDecimal
import kotlin.jvm.JvmName
import kotlin.math.pow

interface Ratio<N, D> {
    val numerator: N
    val denominator: D

    fun <T> transformNumerator(transform: (N) -> T): Ratio<T, D>
    fun <T> transformDenominator(transform: (D) -> T): Ratio<N, T>
}

/**
 * A ratio between to values.
 */
internal data class SimpleRatio<N, D>(
    override val numerator: N,
    override val denominator: D,
): Ratio<N, D> {
    /**
     * Transform the numerator's value and/or type, leaving the denominator in-tact.
     */
    override fun <T> transformNumerator(transform: (N) -> T) = SimpleRatio(transform(numerator), denominator)

    /**
     * Transform the denominator's value and/or type, leaving the numerator in-tact.
     */
    override fun <T> transformDenominator(transform: (D) -> T) = SimpleRatio(numerator, transform(denominator))
}

/**
 * Create a ratio structure
 */
fun <N, D> ratioOf(numerator: N, denominator: D): Ratio<N, D> = SimpleRatio(numerator, denominator)

/**
 * Create a ratio structure
 *
 * Convenience method to create a ratio with an infix syntax
 */
infix fun <N, D> N.per(denominator: D): Ratio<N, D> = ratioOf(this, denominator)

/**
 * Create a ratio from two dimensions
 *
 * Convenience method to create a ratio with an operator syntax
 */
operator fun <N: Dimension<N>, D: Dimension<D>> N.div(denominator: D): Ratio<N, D> = ratioOf(this, denominator)

/**
 * Get the raw value of a dimension ratio.
 */
fun <N: Dimension<N>, D: Dimension<D>> Ratio<N, D>.value(
    numeratorScale: DimensionScale = Nominal,
    denominatorScale: DimensionScale = Nominal,
): Number = numerator.value(scale = numeratorScale).toDouble().div(denominator.value(scale = denominatorScale).toDouble())

/**
 * Get the raw value of a dimension ratio per unit area.
 */
@JvmName("densityValue")
fun <N: Dimension<N>, D: Dimension<D>> Ratio<N, Square<D>>.value(
    numeratorScale: DimensionScale = Nominal,
    denominatorScale: DimensionScale = Nominal,
): Number = numerator.value(scale = numeratorScale).toDouble().div(denominator.value.value(denominatorScale).toDouble().pow(2))

/**
 * Format a ratio of dimensions into a string.
 *
 * @param numeratorScale The scale to display the numerator number in.
 * @param denominatorScale The scale to display the numerator number in.
 * @param decimals The number of decimal places to display.
 * @param round Whether to round the decimal, otherwise it will be floored.
 * @param includeSymbols Whether to append the dimension and scale's unit symbols in the string output.
 * @param decimalSeparator The separation character for the decimal point.
 * @return A string representation of the number, with the decimal formatted.
 */
fun <N: Dimension<N>, D: Dimension<D>> Ratio<N, D>.format(
    numeratorScale: DimensionScale = Nominal,
    denominatorScale: DimensionScale = Nominal,
    decimals: Int = 0,
    round: Boolean = true,
    includeSymbols: Boolean = true,
    decimalSeparator: Char = '.',
): String {
    val value = value(numeratorScale, denominatorScale)
        .formatDecimal(
            decimals = decimals,
            round = round,
            decimalSeparator = decimalSeparator,
        )
    val symbol = "${numeratorScale.prefix}${numerator.symbol}/${denominatorScale.prefix}${denominator.symbol}"
        .takeIf { includeSymbols }.orEmpty()

    return "$value$symbol"
}

/**
 * Format a ratio of dimensions into a string.
 *
 * @param numeratorScale The scale to display the numerator number in.
 * @param denominatorScale The scale to display the numerator number in.
 * @param decimals The number of decimal places to display.
 * @param round Whether to round the decimal, otherwise it will be floored.
 * @param includeSymbols Whether to append the dimension and scale's unit symbols in the string output.
 * @param decimalSeparator The separation character for the decimal point.
 * @return A string representation of the number, with the decimal formatted.
 */
@JvmName("densityFormat")
fun <N: Dimension<N>, D: Dimension<D>> Ratio<N, Square<D>>.format(
    numeratorScale: DimensionScale = Nominal,
    denominatorScale: DimensionScale = Nominal,
    decimals: Int = 0,
    round: Boolean = true,
    includeSymbols: Boolean = true,
    decimalSeparator: Char = '.',
): String {
    val value = value(numeratorScale, denominatorScale)
        .formatDecimal(
            decimals = decimals,
            round = round,
            decimalSeparator = decimalSeparator,
        )
    val symbol = "${numeratorScale.prefix}${numerator.symbol}/${denominatorScale.prefix}${denominator.value.symbol}^2"
        .takeIf { includeSymbols }.orEmpty()

    return "$value$symbol"
}
