package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Represents a Temperature value.
 */
@JvmInline
value class Temperature internal constructor(override val rawValue: Double): DoubleMeasurement<Temperature> {
    override val storedUnit: DoubleUnit<Temperature> get() = Kelvin
}

object Kelvin: StoredUnit<Temperature>() {
    override fun of(value: Number): Temperature = Temperature(value.toDouble())
}

object Celsius: DoubleUnit<Temperature> by Kelvin - 273.15
object Fahrenheit: DoubleUnit<Temperature> by (Kelvin - 273.15) * 1.8 + 32
