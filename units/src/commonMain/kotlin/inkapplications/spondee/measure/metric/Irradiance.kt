package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.Irradiance
import inkapplications.spondee.structure.Ratio
import inkapplications.spondee.structure.Square
import inkapplications.spondee.structure.per

/**
 * Convenience method to create a ratio of this value per square meter.
 */
val Number.wattsPerSquareMeter get() = watts per Square(Meter)

/**
 * Transform an irradiance value to the common watts per square meter value.
 */
fun Irradiance.toWattsPerSquareMeter(): Ratio<Watts, Square<Meters>> = transformNumerator { it.toWatts() }
    .transformDenominator { Square(it.value.toMeters()) }
