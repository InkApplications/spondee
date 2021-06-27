package inkapplications.spondee.measure

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Unit of measurement for a length/distance.
 */
@JvmInline
value class Length internal constructor(override val rawValue: Double): DoubleMeasurement<Length> {
    override val storedUnit get() = Meters
}

/**
 * SI Unit of length
 */
object Meters: StoredUnit<Length>() {
    override fun of(value: Number): Length = Length(value.toDouble())
}

object Miles: DoubleUnit<Length> by Feet / 5280
object Yards: DoubleUnit<Length> by Feet / 3
object Feet: DoubleUnit<Length> by Meters * 3.280_840
object Inches: DoubleUnit<Length> by Feet * 12
object HundredthInches: DoubleUnit<Length> by Inches * 100
object ThousandthInches: DoubleUnit<Length> by Inches * 1000
