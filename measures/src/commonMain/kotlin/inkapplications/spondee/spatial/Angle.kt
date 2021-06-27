package inkapplications.spondee.spatial

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline
import kotlin.math.PI


/**
 * Unit of angle or bearing.
 */
@JvmInline
value class Angle internal constructor(override val rawValue: Double): Measurement<Angle> {
    override val storedUnit: MeasurementUnit<Angle> get() = Radians
}

object Radians: BaseUnit<Angle>() {
    override fun of(value: Number): Angle = Angle(value.toDouble())
}

object Degrees: MeasurementUnit<Angle> by Radians * (180.0 / PI)

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
