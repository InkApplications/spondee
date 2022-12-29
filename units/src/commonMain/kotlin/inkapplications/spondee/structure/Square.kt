package inkapplications.spondee.structure

import inkapplications.spondee.format.formatDecimal

/**
 * Wraps a dimension to form a square area dimension.
 */
data class Square<out T>(val value: T) {
    override fun toString(): String = "($value)^2"
}

/**
 * Format a ratio of dimensions into a string.
 *
 * @param scale The scale to display the number in.
 * @param decimals The number of decimal places to display.
 * @param round Whether to round the decimal, otherwise it will be floored.
 * @param includeSymbols Whether to append the dimension and scale's unit symbols in the string output.
 * @param decimalSeparator The separation character for the decimal point.
 * @return A string representation of the number, with the decimal formatted.
 */
fun <T: Dimension<T>> Square<T>.format(
    scale: DimensionScale = Nominal,
    decimals: Int = 0,
    round: Boolean = true,
    includeSymbols: Boolean = true,
    decimalSeparator: Char = '.',
): String {
    val formattedValue = value.value(scale)
        .formatDecimal(
            decimals = decimals,
            round = round,
            decimalSeparator = decimalSeparator,
        )
    val symbol = "${scale.prefix}${value.symbol}^2"
        .takeIf { includeSymbols }.orEmpty()

    return "$formattedValue$symbol"
}
