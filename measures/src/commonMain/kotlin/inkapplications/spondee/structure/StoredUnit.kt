package inkapplications.spondee.structure

import inkapplications.spondee.format.formatDecimal

/**
 * The 'base' storage unit for a measurement.
 *
 * The unit for any measurement that is used as the unit from which other
 * measurement units are derived.
 * Since each measurement should only have one of these, the value can be
 * accessed through its raw value, which is stubbed out in this base class.
 *
 * @param symbol Symbol used for formatting the unit.
 */
abstract class StoredUnit<M: DoubleMeasurement<M>>(
    override val symbol: String,
): DoubleUnit<M>, Symbolized, UnitFormatter<M> {
    final override fun convertValue(value: M): Double = value.rawValue
    override fun format(
        measurement: M,
        decimals: Int,
        decimalSeparator: Char,
    ): String = "${convertValue(measurement).formatDecimal(decimals, true, decimalSeparator)}${symbol}"

    override fun format(
        measurement: M,
        siScale: SiScale,
        decimals: Int,
        decimalSeparator: Char,
    ): String = "${measurement.value(siScale, this).formatDecimal(decimals, true, decimalSeparator)}${siScale.symbol}$symbol"
}
