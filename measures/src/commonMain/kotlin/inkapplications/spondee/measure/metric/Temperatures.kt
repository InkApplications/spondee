package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.ColorTemperature
import inkapplications.spondee.measure.Temperature
import inkapplications.spondee.structure.Dimension
import inkapplications.spondee.structure.Symbolized
import inkapplications.spondee.structure.minus
import inkapplications.spondee.structure.plus
import kotlin.jvm.JvmInline

/**
 * SI Metric temperature unit.
 */
@JvmInline
value class Kelvin(override val value: Number): Temperature, ColorTemperature, Dimension<Kelvin>, Symbolized {
    override val symbol: String get() = "K"
    override fun toKelvin(): Kelvin = this
    override fun withValue(value: Number): Kelvin = Kelvin(value)

    override fun toString(): String = "$value$symbol"
}

/**
 * Express this number as a temperature unit in Kelvin
 */
val Number.kelvin get() = Kelvin(this)

/**
 * Alternate metric unit of temperature
 */
@JvmInline
value class Celsius(override val value: Number): Temperature, Dimension<Celsius>, Symbolized {
    override val symbol: String get() = "ºC"
    override fun toKelvin(): Kelvin  = plus(273.15).value.kelvin
    override fun withValue(value: Number): Celsius = Celsius(value)
    override fun toString(): String = "$value$symbol"
}

/**
 * Express this number as a temperature unit in celsius
 */
val Number.celsius get() = Celsius(this)

/**
 * Convert a temperature unit to celsius
 */
fun Temperature.toCelsius() = toKelvin().minus(273.15).value.celsius
