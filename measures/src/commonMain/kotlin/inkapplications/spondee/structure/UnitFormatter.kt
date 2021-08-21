package inkapplications.spondee.structure

/**
 * Convert measurements to strings.
 */
interface UnitFormatter<T: Measurement<T>> {
    fun format(measurement: T): String
    fun format(measurement: T, siScale: SiScale): String
}
