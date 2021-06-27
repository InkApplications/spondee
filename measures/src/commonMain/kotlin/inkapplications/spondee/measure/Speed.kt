@file:OptIn(ExperimentalTime::class)
package inkapplications.spondee.measure

import inkapplications.spondee.structure.BaseUnit
import inkapplications.spondee.structure.Measurement
import inkapplications.spondee.structure.MeasurementUnit
import inkapplications.spondee.structure.value
import kotlin.jvm.JvmInline
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

@JvmInline
value class Speed internal constructor(override val rawValue: Double): Measurement<Speed> {
    override val storedUnit: MeasurementUnit<Speed> get() = MetersPerSecond
    val lengthComponent: Length get() = Meters.of(rawValue)
    val durationComponent: Duration get() = Duration.seconds(1)
}

object MetersPerSecond: BaseUnit<Speed>() {
    override fun of(value: Number): Speed = Speed(value.toDouble())
}

object MilesPerHour: MeasurementUnit<Speed> {
    override fun convertValue(value: Speed): Double {
        return value.lengthComponent.value(Miles) / value.durationComponent.toDouble(DurationUnit.HOURS)
    }

    override fun of(value: Number): Speed {
        return MetersPerSecond.of(Miles.of(value).value(Meters) / Duration.hours(1).toDouble(DurationUnit.SECONDS))
    }
}

