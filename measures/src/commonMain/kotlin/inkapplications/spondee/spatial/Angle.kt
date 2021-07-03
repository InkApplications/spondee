package inkapplications.spondee.spatial

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline
import kotlin.math.PI

/**
 * Unit of angle or bearing.
 */
@JvmInline
value class Angle internal constructor(override val rawValue: Double): DoubleMeasurement<Angle> {
    override val storedUnit: DoubleUnit<Angle> get() = Radians
}

object Radians: StoredUnit<Angle>(
    symbol = ""
) {
    override fun of(value: Number): Angle = Angle(value.toDouble())
}

object Degrees: DerivedUnit<Angle>(
    definition = Radians * (180.0 / PI),
    symbol = "º"
)

/**
 * Convert a cardinal direction to an angle in degrees clockwise from 0º North.
 */
fun Angle.toNearestCardinal(): Cardinal {
    return when {
        this % Degrees.of(360) <= Cardinal.North.toAngle() + Degrees.of(45) -> Cardinal.North
        this % Degrees.of(360) <= Cardinal.East.toAngle() + Degrees.of(45) -> Cardinal.East
        this % Degrees.of(360) <= Cardinal.South.toAngle() + Degrees.of(45) -> Cardinal.South
        else -> Cardinal.West
    }
}
