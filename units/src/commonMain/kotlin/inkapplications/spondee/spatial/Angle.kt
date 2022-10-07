package inkapplications.spondee.spatial

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline
import kotlin.math.PI

/**
 * Unit of angle or bearing.
 */
interface Angle {
    fun toRadians(): Radians
}

/**
 * Angle in radians
 */
@JvmInline
value class Radians(override val value: Number): Angle, Dimension<Radians> {
    override val symbol: String get() = ""
    override fun toString(): String = format()
    override fun toRadians(): Radians = this
    override fun withValue(value: Number): Radians = Radians(value)
}

/**
 * Express this number as an angle in radians
 */
val Number.radians get() = Radians(this)

/**
 * Angle in degrees
 */
@JvmInline
value class Degrees(override val value: Number): Angle, Dimension<Degrees> {
    override val symbol: String get() = "º"
    override fun toRadians(): Radians = convert { this / (180.0 / PI) }.radians
    override fun toString(): String = format()
    override fun withValue(value: Number): Degrees = Degrees(value)
}

/**
 * Express this number as an angle in degrees
 */
val Number.degrees get() = Degrees(this)

/**
 * Convert an angle to degrees.
 */
fun Angle.toDegrees() = toRadians().convert { this * (180.0 / PI) }.degrees

/**
 * Convert a cardinal direction to an angle in degrees clockwise from 0º North.
 */
fun Angle.toNearestCardinal(): Cardinal {
    return when {
        toDegrees() % 360.degrees <= Cardinal.North.toDegrees() + 45.degrees -> Cardinal.North
        toDegrees() % 360.degrees <= Cardinal.East.toDegrees() + 45.degrees -> Cardinal.East
        toDegrees() % 360.degrees <= Cardinal.South.toDegrees() + 45.degrees -> Cardinal.South
        else -> Cardinal.West
    }
}
