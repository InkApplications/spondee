package inkapplications.spondee.structure

import inkapplications.spondee.format.SimpleNumberFormats
import inkapplications.spondee.format.formatDecimal

/**
 * A unit that delegates to another for its definition.
 *
 * @param definition The the unit definition to delegate to.
 * @param symbol A symbol for this unit, used in formatting.
 */
@OptIn(SimpleNumberFormats::class)
abstract class DerivedUnit<T: DoubleMeasurement<T>>(
    definition: DoubleUnit<T>,
    override val symbol: String,
): DoubleUnit<T> by definition, UnitFormatter<T>, Symbolized {
    override fun format(
        measurement: T,
        decimals: Int,
        decimalSeparator: Char,
    ): String = "${convertValue(measurement).formatDecimal(decimals, true, decimalSeparator)}${symbol}"

    override fun format(
        measurement: T,
        siScale: SiScale,
        decimals: Int,
        decimalSeparator: Char,
    ): String = "${measurement.value(siScale, this).formatDecimal(decimals, true, decimalSeparator)}${siScale.symbol}${symbol}"
}
