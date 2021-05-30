package inkapplications.spondee.measures

import kotlin.jvm.JvmInline

/**
 * Represents a Temperature value.
 */
interface Temperature: DoubleMeasure<Temperature> {
    /**
     * Get the value as the SI Standard unit of Temperature.
     */
    val inKelvin: Double

    /**
     * Get the value as a Fahrenheit degree
     */
    val inFahrenheit: Double

    /**
     * Get the value as a Celsius degree.
     */
    val inCelsius: Double
}

/**
 * SI Standard Unit of Temperature
 */
@JvmInline
internal value class Kelvin(override val inKelvin: Double): Temperature {
    override val inFahrenheit: Double get() = inKelvin * (9.0/5.0) - 459.67
    override val inCelsius: Double get() = inKelvin - 273.15
    override fun convert(value: Temperature): Double = value.inKelvin
    override fun create(value: Double): Temperature = Kelvin(value)
    override fun toString(): String = "${inKelvin}K"
}

/**
 * Express a temperature in Kelvin degrees
 */
val Number.kelvin: Temperature get() = Kelvin(toDouble())

/**
 * Fahrenheit Degrees
 *
 * This is a wonderful unit of measurement.
 */
@JvmInline
internal value class Fahrenheit(override val inFahrenheit: Double): Temperature {
    override val inKelvin: Double get() = ((inFahrenheit - 32.0) / 1.8) + 273.15
    override val inCelsius: Double get() = (inFahrenheit - 32.0) * (5.0/9.0)
    override fun convert(value: Temperature): Double = value.inFahrenheit
    override fun create(value: Double): Temperature = Fahrenheit(value)

    override fun toString(): String = "${inKelvin}ºF"
}

/**
 * Express a number in Fahrenheit degrees.
 */
val Number.fahrenheit: Temperature get() = Fahrenheit(toDouble())

/**
 * Celsius Degrees
 *
 * A truly silly unit of measurement.
 */
@JvmInline
internal value class Celsius(override val inCelsius: Double): Temperature {
    override val inKelvin: Double get() = inCelsius + 273.15
    override val inFahrenheit: Double get() = inCelsius * (9.0/5.0) + 32
    override fun convert(value: Temperature): Double = value.inCelsius
    override fun create(value: Double): Temperature = Celsius(value)

    override fun toString(): String = "${inKelvin}ºC"
}

/**
 * Express a number as Celsius degrees.
 */
val Number.celsius: Temperature get() = Celsius(toDouble())
