package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

@JvmInline
value class ColorTemperature internal constructor(override val rawValue: Double): DoubleMeasurement<ColorTemperature> {
    override val storedUnit: DoubleUnit<ColorTemperature> get() = KelvinColorTemperature
}

internal object KelvinColorTemperature: StoredUnit<ColorTemperature>() {
    override fun of(value: Number): ColorTemperature = ColorTemperature(value.toDouble())
}

fun Temperature.toColorTemperature(): ColorTemperature = KelvinColorTemperature.of(value(Kelvin))
fun ColorTemperature.toTemperature(): Temperature = Kelvin.of(rawValue)

object Mireds: DoubleUnit<ColorTemperature> by KelvinColorTemperature.pow(-1) * 1_000_000
