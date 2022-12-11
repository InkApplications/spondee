package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Grams

/**
 * A unit of measurement for mass.
 */
interface Mass {
    fun toGrams(): Grams
}
