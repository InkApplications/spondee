package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Represents a Temperature value.
 */
@JvmInline
value class Temperature internal constructor(override val baseValue: Double): Measurement<Temperature> {
    override val baseUnit: MeasurementUnit<Temperature> get() = TODO()
}

object Kelvin: BaseUnit<Temperature>() {
    override fun of(value: Number): Temperature = Temperature(value.toDouble())
}

object Celsius: MeasurementUnit<Temperature> by Kelvin - 273.15
object Fahrenheit: MeasurementUnit<Temperature> by (Kelvin - 273.15) * 1.8 + 32
