package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Unit of measurement for a length/distance.
 */
@JvmInline
value class Length internal constructor(override val rawValue: Double): Measurement<Length> {
    override val storedUnit get() = Meters
}

/**
 * SI Unit of length
 */
object Meters: BaseUnit<Length>() {
    override fun of(value: Number): Length = Length(value.toDouble())
}

object Miles: MeasurementUnit<Length> by Feet / 5280
object Yards: MeasurementUnit<Length> by Feet / 3
object Feet: MeasurementUnit<Length> by Meters * 3.280_840
object Inches: MeasurementUnit<Length> by Feet * 12
object HundredthInches: MeasurementUnit<Length> by Inches * 100
object ThousandthInches: MeasurementUnit<Length> by Inches * 1000
