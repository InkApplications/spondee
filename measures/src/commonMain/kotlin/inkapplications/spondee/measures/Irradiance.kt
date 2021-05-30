package inkapplications.spondee.measures

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
