package inkapplications.spondee.measure

import inkapplications.spondee.measure.metric.Kelvin
import inkapplications.spondee.measure.metric.kelvin
import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Lighting color temperature.
 */
interface ColorTemperature {
    fun toKelvin(): Kelvin
}

/**
 * Color temperature unit as a micro reciprocal degree.
 */
@JvmInline
value class Mireds(override val value: Number): ColorTemperature, Dimension<Mireds>, Symbolized {
    override fun withValue(value: Number): Mireds = Mireds(value)
    override fun toKelvin() = convert { 1_000_000.0 / this }.kelvin
    override val symbol: String get() = "MK^-1"
    override fun toString(): String = format()
}

/**
 * Express the current value as a color-temperature in Mireds
 */
val Number.mireds get() = Mireds(this)

/**
 * Convenience reference constant for a single Mired
 */
val Mired = 1.mireds

/**
 * Convert a color temperature to Mireds.
 */
fun ColorTemperature.toMireds() = toKelvin().convert { 1_000_000.0 / this }.mireds

