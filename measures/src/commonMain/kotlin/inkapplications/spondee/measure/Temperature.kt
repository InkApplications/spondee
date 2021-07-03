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

object Kelvin: StoredUnit<Temperature>(
    symbol = "K"
) {
    override fun of(value: Number): Temperature = Temperature(value.toDouble())
}

object Celsius: DerivedUnit<Temperature>(
    definition = Kelvin - 273.15,
    symbol = "ºC",
)
object Fahrenheit: DerivedUnit<Temperature>(
    definition = (Kelvin - 273.15) * 1.8 + 32,
    symbol = "ºF",
)
