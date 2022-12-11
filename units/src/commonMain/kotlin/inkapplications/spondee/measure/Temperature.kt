package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Kelvin

/**
 * Unit of thermal temperature.
 */
interface Temperature {
    fun toKelvin(): Kelvin
}
