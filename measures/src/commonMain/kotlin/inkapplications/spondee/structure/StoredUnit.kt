package inkapplications.spondee.structure

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
    override fun format(measurement: M): String = "${convertValue(measurement)}${symbol}"
}
