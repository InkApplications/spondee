package inkapplications.spondee.structure

/**
 * Convert measurements to strings.
 */
interface UnitFormatter<T: Measurement<T>> {
    fun format(
        measurement: T,
        decimals: Int = 1,
        decimalSeparator: Char = '.',
    ): String

    fun format(
        measurement: T,
        siScale: SiScale,
        decimals: Int = 1,
        decimalSeparator: Char = '.',
    ): String
}
