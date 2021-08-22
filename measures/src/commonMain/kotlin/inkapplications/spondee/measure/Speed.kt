@file:OptIn(ExperimentalTime::class)
package inkapplications.spondee.measure

import inkapplications.spondee.format.formatDecimal
import inkapplications.spondee.structure.*
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

object MetersPerSecond: StoredUnit<Speed>(
    symbol = "m/s"
) {
    override fun of(value: Number): Speed = Speed(value.toDouble())
}

object MilesPerHour: DoubleUnit<Speed>, Symbolized, UnitFormatter<Speed> {
    override val symbol: String = "mph"

    override fun convertValue(value: Speed): Double {
        return value.lengthComponent.value(Miles) / value.durationComponent.toDouble(DurationUnit.HOURS)
    }

    override fun of(value: Number): Speed {
        return MetersPerSecond.of(Miles.of(value).value(Meters) / Duration.hours(1).toDouble(DurationUnit.SECONDS))
    }

    override fun format(measurement: Speed, decimals: Int, decimalSeparator: Char): String = "${convertValue(measurement).formatDecimal(decimals, true, decimalSeparator)}$symbol"
    override fun format(measurement: Speed, siScale: SiScale, decimals: Int, decimalSeparator: Char): String = "${measurement.value(siScale, this).formatDecimal(decimals, true, decimalSeparator)}${siScale.symbol}${symbol}"
}
