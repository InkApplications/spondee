@file:OptIn(ExperimentalTime::class)
package inkapplications.spondee.measure

import inkapplications.spondee.structure.StoredUnit
import inkapplications.spondee.structure.DoubleMeasurement
import inkapplications.spondee.structure.DoubleUnit
import inkapplications.spondee.structure.value
import kotlin.jvm.JvmInline
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

@JvmInline
value class Speed internal constructor(override val rawValue: Double): DoubleMeasurement<Speed> {
    override val storedUnit: DoubleUnit<Speed> get() = MetersPerSecond
    val lengthComponent: Length get() = Meters.of(rawValue)
    val durationComponent: Duration get() = Duration.seconds(1)
}

object MetersPerSecond: StoredUnit<Speed>() {
    override fun of(value: Number): Speed = Speed(value.toDouble())
}

object MilesPerHour: DoubleUnit<Speed> {
    override fun convertValue(value: Speed): Double {
        return value.lengthComponent.value(Miles) / value.durationComponent.toDouble(DurationUnit.HOURS)
    }

    override fun of(value: Number): Speed {
        return MetersPerSecond.of(Miles.of(value).value(Meters) / Duration.hours(1).toDouble(DurationUnit.SECONDS))
    }
}

