package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Kelvin

interface Temperature {
    fun toKelvin(): Kelvin
}
