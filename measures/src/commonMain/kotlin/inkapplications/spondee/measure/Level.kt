package inkapplications.spondee.measure

import inkapplications.spondee.structure.BaseUnit
import inkapplications.spondee.structure.Measurement
import inkapplications.spondee.structure.MeasurementUnit
import kotlin.jvm.JvmInline

/**
 * Unit of a ratio. Most commonly decibels.
 */
@JvmInline
value class Level internal constructor(override val rawValue: Double): Measurement<Level> {
    override val storedUnit: MeasurementUnit<Level> get() = Bels
}

object Bels: BaseUnit<Level>() {
    override fun of(value: Number): Level = Level(value.toDouble())
}
