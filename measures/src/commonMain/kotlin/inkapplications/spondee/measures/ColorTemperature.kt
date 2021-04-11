package inkapplications.spondee.measures

/**
 * Lighting Color Temperature Unit.
 */
interface ColorTemperature {
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
internal data class MiredColorTemperature(
    override val inMireds: Double,
): ColorTemperature {
    override val inKelvin get() = 1_000_000 / inMireds
    override val asTemperature get() = inKelvin.kelvin
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
internal data class StandardColorTemperature(
    override val asTemperature: Temperature,
): ColorTemperature {
    override val inKelvin: Double get() = asTemperature.inKelvin
    override val inMireds: Double get() = 1_000_000 / inKelvin
}

/**
 * Express a Temperature unit as a Color Temperature.
 *
 * Typically used for converting Kelvin to a color temperature.
 */
val Temperature.asColorTemperature: ColorTemperature get() = StandardColorTemperature(this)



