package inkapplications.spondee.spatial

import inkapplications.spondee.structure.DoubleMeasure
import inkapplications.spondee.structure.compareTo
import inkapplications.spondee.structure.plus
import inkapplications.spondee.structure.rem
import kotlin.jvm.JvmInline
import kotlin.math.PI

/**
 * Unit of angle or bearing.
 */
interface Angle: DoubleMeasure<Angle> {
    /**
     * Express the angle in degrees.
     */
    val inDegrees: Double

    /**
     * Express the angle in radians.
     */
    val inRadians: Double
}

@JvmInline
internal value class Degrees(override val inDegrees: Double): Angle {
    override val inRadians: Double get() = inDegrees * (PI / 180)

    override fun convert(value: Angle): Double = value.inDegrees
    override fun create(value: Double): Angle = Degrees(value)

    override fun toString(): String = "${inDegrees}º"
}

/**
 * Express a number as Angle in degrees.
 */
val Number.degrees: Angle get() = Degrees(toDouble())
val degree = 1.degrees

@JvmInline
internal value class Radians(override val inRadians: Double): Angle {
    override val inDegrees: Double get() = inRadians * (180 / PI)
    override fun convert(value: Angle): Double = value.inRadians
    override fun create(value: Double): Angle = Radians(value)

    override fun toString(): String = inRadians.toString()
}

/**
 * Express a number as an Angle in radians.
 */
val Number.radians: Angle get() = Radians(toDouble())
val radian = 1.radians

/**
 * Convert a cardinal direction to an angle in degrees clockwise from 0º North.
 */
fun Angle.toNearestCardinal(): Cardinal {
    return when {
        this % 360.degrees <= Cardinal.North.toAngle() + 45.degrees -> Cardinal.North
        this % 360.degrees <= Cardinal.East.toAngle() + 45.degrees -> Cardinal.East
        this % 360.degrees <= Cardinal.South.toAngle() + 45.degrees -> Cardinal.South
        else -> Cardinal.West
    }
}
