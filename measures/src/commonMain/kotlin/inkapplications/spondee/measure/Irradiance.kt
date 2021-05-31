package inkapplications.spondee.measure

import inkapplications.spondee.structure.Ratio
import inkapplications.spondee.structure.Square
import inkapplications.spondee.structure.per

/**
 * Power per unit area.
 */
typealias Irradiance = Ratio<Power, Square<Length>>

/**
 * Express a number representing Irradiance as watts per square meter.
 */
val Number.wattsPerSquareMeter: Irradiance get() = toDouble().watts per Square(meter)

/**
 * Express the irradiance in watts per square meter
 */
val Irradiance.inWattsPerSquareMeter: Double get() = numerator.inWatts * denominator.width.inMeters
