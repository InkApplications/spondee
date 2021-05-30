package inkapplications.spondee.measures

import kotlin.jvm.JvmInline

/**
 * Lighting Color Temperature Unit.
 */
interface ColorTemperature: DoubleMeasure<ColorTemperature> {
    /**
     * Express the color temperature in kelvin units.
     */
    val inKelvin: Double

    /**
     * Express the color temperature in reciprocal degrees.
     */
    val inMireds: Double

    /**
     * Express the value as a standard temperature unit.
     */
    val asTemperature: Temperature
}

/**
 * Reciprocal Degree Color Temperature Unit.
 */
@JvmInline
internal value class MiredColorTemperature(
    override val inMireds: Double,
): ColorTemperature {
    override val inKelvin get() = 1_000_000 / inMireds
    override val asTemperature get() = inKelvin.kelvin
    override fun convert(value: ColorTemperature): Double = value.inMireds
    override fun create(value: Double): ColorTemperature = MiredColorTemperature(value)

    override fun toString(): String = "${inMireds}MK^−1"
}

/**
 * Express a number as Mired units.
 */
val Number.mireds: ColorTemperature get() = MiredColorTemperature(toDouble())

/**
 * Temperature Unit Based Color Temperature.
 *
 * This is universally measured in degrees Kelvin, but could be any unit
 * of temperature.
 */
@JvmInline
internal value class StandardColorTemperature(
    override val asTemperature: Temperature,
): ColorTemperature {
    override val inKelvin: Double get() = asTemperature.inKelvin
    override val inMireds: Double get() = 1_000_000 / inKelvin
    override fun convert(value: ColorTemperature): Double = asTemperature.convert(value.asTemperature)
    override fun create(value: Double): ColorTemperature = StandardColorTemperature(asTemperature.create(value))

    override fun toString(): String = asTemperature.toString()
}

/**
 * Express a Temperature unit as a Color Temperature.
 *
 * Typically used for converting Kelvin to a color temperature.
 */
val Temperature.asColorTemperature: ColorTemperature get() = StandardColorTemperature(this)



