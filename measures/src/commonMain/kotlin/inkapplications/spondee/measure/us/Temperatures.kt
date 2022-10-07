package inkapplications.spondee.measure.us

import inkapplications.spondee.measure.Temperature
import inkapplications.spondee.measure.metric.Kelvin
import inkapplications.spondee.measure.metric.celsius
import inkapplications.spondee.measure.metric.toCelsius
import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * US Customary unit of temperature
 */
@JvmInline
value class Fahrenheit(override val value: Number): Temperature, Dimension<Fahrenheit>, Symbolized {
    override val symbol: String get() = "ºF"
    override fun toKelvin(): Kelvin = convert { (celsius - 32) / 1.8 }.toKelvin()
    override fun withValue(value: Number): Fahrenheit = Fahrenheit(value)
    override fun toString(): String = "$value$symbol"
}

/**
 * Express this number as a unit in fahrenheit.
 */
val Number.fahrenheit get() = Fahrenheit(this)

/**
 * Convert a unit of temperature to fahrenheit
 */
fun Temperature.toFahrenheit() = toCelsius().convert { this * 1.8 + 32 }.fahrenheit
