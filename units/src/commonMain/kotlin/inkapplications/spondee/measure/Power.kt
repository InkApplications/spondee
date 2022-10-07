package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Watts

/**
 * Unit of energy per unit time
 */
interface Power {
    fun toWatts(): Watts
}
