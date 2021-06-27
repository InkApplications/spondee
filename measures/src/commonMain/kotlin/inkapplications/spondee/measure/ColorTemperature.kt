package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline
import kotlin.math.pow

@JvmInline
value class ColorTemperature internal constructor(override val baseValue: Double): Measurement<ColorTemperature> {
    override val baseUnit: MeasurementUnit<ColorTemperature> get() = KelvinColorTemperature
}

internal object KelvinColorTemperature: BaseUnit<ColorTemperature>() {
    override fun of(value: Number): ColorTemperature = ColorTemperature(value.toDouble())
}

fun Temperature.toColorTemperature(): ColorTemperature = KelvinColorTemperature.of(value(Kelvin))
fun ColorTemperature.toTemperature(): Temperature = Kelvin.of(baseValue)

object Mireds: MeasurementUnit<ColorTemperature> by KelvinColorTemperature.pow(-1) * 1_000_000
