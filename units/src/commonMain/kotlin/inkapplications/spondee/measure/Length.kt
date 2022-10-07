package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Meters

/**
 * Unit of measurement for a length/distance.
 */
interface Length {
    fun toMeters(): Meters
}
