package inkapplications.spondee.measure

import inkapplications.spondee.structure.StoredUnit
import inkapplications.spondee.structure.DoubleMeasurement
import inkapplications.spondee.structure.DoubleUnit
import kotlin.jvm.JvmInline

/**
 * Unit of a ratio. Most commonly decibels.
 */
@JvmInline
value class Level internal constructor(override val rawValue: Double): DoubleMeasurement<Level> {
    override val storedUnit: DoubleUnit<Level> get() = Bels
}

object Bels: StoredUnit<Level>() {
    override fun of(value: Number): Level = Level(value.toDouble())
}
