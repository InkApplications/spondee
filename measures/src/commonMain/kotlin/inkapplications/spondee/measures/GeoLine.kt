package inkapplications.spondee.measures

import kotlin.math.abs

/**
 * A Latitude/Longitude line.
 *
 * This can be expressed as a decimal as part of Lat/Lng lookups
 * or as degrees/minutes/seconds and a Cardinal.
 */
sealed class GeoLine(
    private val decimal: Double
): Number() {
    val degrees: Int = abs(decimal.toInt())
    val minutes: Int = ((abs(decimal) - degrees) * 60).toInt()
    val seconds: Float = ((abs(decimal) - degrees - (minutes / 60.0)) * 3600).toFloat()
    abstract val cardinal: Cardinal

    override fun toByte(): Byte = decimal.toInt().toByte()
    override fun toChar(): Char = decimal.toChar()
    override fun toDouble(): Double = decimal
    override fun toFloat(): Float = decimal.toFloat()
    override fun toInt(): Int = decimal.toInt()
    override fun toLong(): Long = decimal.toLong()
    override fun toShort(): Short = decimal.toInt().toShort()
}

/**
 * Convert degrees notation to a decimal.
 */
private fun toDecimal(
    degrees: Int,
    minutes: Int,
    seconds: Float,
    cardinal: Cardinal,
) = (degrees.toDouble() + (minutes.toDouble() / 60.0) + (seconds / 3600.0)) * cardinal.decimalSign

/**
 * Latitude/parallel position of a coordinate.
 */
data class Latitude(val decimal: Double): GeoLine(decimal) {
    constructor(
        degrees: Int,
        minutes: Int,
        seconds: Float,
        cardinal: Cardinal,
    ): this(toDecimal(degrees, minutes, seconds, cardinal))

    override val cardinal: Cardinal = if (decimal > 0) Cardinal.North else Cardinal.South
}

/**
 * Longitude/meridian position of a coordinate.
 */
data class Longitude(val decimal: Double): GeoLine(decimal) {
    constructor(
        degrees: Int,
        minutes: Int,
        seconds: Float,
        cardinal: Cardinal,
    ): this(toDecimal(degrees, minutes, seconds, cardinal))

    override val cardinal: Cardinal = if (decimal > 0) Cardinal.East else Cardinal.West
}

/**
 * Express a latitude line from decimal degrees.
 */
val Number.latitude get() = Latitude(toDouble())

/**
 * Express a longitude line from decimal degrees.
 */
val Number.longitude get() = Latitude(toDouble())
