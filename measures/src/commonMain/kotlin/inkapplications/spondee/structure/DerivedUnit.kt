package inkapplications.spondee.structure

/**
 * A unit that delegates to another for its definition.
 *
 * @param definition The the unit definition to delegate to.
 * @param symbol A symbol for this unit, used in formatting.
 */
abstract class DerivedUnit<T: DoubleMeasurement<T>>(
    definition: DoubleUnit<T>,
    override val symbol: String,
): DoubleUnit<T> by definition, UnitFormatter<T>, Symbolized {
    override fun format(measurement: T): String = "${convertValue(measurement)}${symbol}"
}
