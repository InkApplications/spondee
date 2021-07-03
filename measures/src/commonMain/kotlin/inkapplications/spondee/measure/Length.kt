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
object Meters: StoredUnit<Length>(symbol = "m") {
    override fun of(value: Number): Length = Length(value.toDouble())
}

object Miles: DerivedUnit<Length>(
    definition = Feet / 5280,
    symbol = "mi",
)

object Yards: DerivedUnit<Length>(
    definition = Feet / 3,
    symbol = "yd",
)
object Feet: DerivedUnit<Length>(
    definition = Meters * 3.280_840,
    symbol = "ft",
)

object Inches: DerivedUnit<Length>(
    definition = Feet * 12,
    symbol = "in",
)

object HundredthInches: DerivedUnit<Length>(
    definition = Inches * 100,
    symbol = "(1/100)in",
)

object ThousandthInches: DerivedUnit<Length>(
    definition = Inches * 1000,
    symbol = "thou",
)
