package inkapplications.spondee.format

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong

/**
 * Formats a number by restricting the number of decimal places.
 *
 * @param decimals The number of decimal places to display.
 * @param round Whether to round the decimal, otherwise it will be floored.
 * @param decimalSeparator The separation character for the decimal point.
 * @return A string representation of the number, with the decimal formatted.
 */
@SimpleNumberFormats
fun Number.formatDecimal(
    decimals: Int = 0,
    round: Boolean = true,
    decimalSeparator: Char = '.',
): String {
    if (decimals == 0) {
        return if (round) toDouble().roundToInt().toString() else toInt().toString()
    }

    val raw = toDouble()
        .times(10.0.pow(decimals))
        .let { if (round) it.roundToLong() else it.toLong() }
        .toString()
        .let { if (it.length < decimals) "0".repeat(decimals - it.length) + it else it }
    val lastChunk = raw.substring(raw.length - decimals, raw.length)
    val firstChunk = raw.substring(0, raw.length - decimals)

    return if (firstChunk.isEmpty()) {
        "0${decimalSeparator}${lastChunk}"
    } else {
        "${firstChunk}${decimalSeparator}${lastChunk}"
    }
}
