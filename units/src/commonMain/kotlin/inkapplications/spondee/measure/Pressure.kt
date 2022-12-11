package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Pascals

interface Pressure {
    fun toPascals(): Pascals
}
