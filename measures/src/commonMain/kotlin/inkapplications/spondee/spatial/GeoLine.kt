package inkapplications.spondee.spatial

import inkapplications.spondee.spatial.Cardinal
import kotlin.jvm.JvmInline
import kotlin.math.abs

/**
 * A Latitude/Longitude line.
 *
 * This can be expressed as a decimal as part of Lat/Lng lookups
 * or as degrees/minutes/seconds and a Cardinal.
 */
sealed interface GeoLine {
    val asDecimal: Double
    val degreesComponent: Int
    val minutesComponent: Int
    val secondsComponent: Float
    val cardinal: Cardinal
}

private val Double.degreesComponent get() = abs(toInt())
private val Double.minutesComponent get() = ((abs(this) - degreesComponent) * 60).toInt()
private val Double.secondsComponent get() = ((abs(this) - degreesComponent - (minutesComponent / 60.0)) * 3600).toFloat()
private fun toDecimal(
    degrees: Int,
    minutes: Int,
    seconds: Float,
    cardinal: Cardinal,
) = (degrees.toDouble() + (minutes.toDouble() / 60.0) + (seconds / 3600.0)) * cardinal.decimalSign

/**
 * Latitude/parallel position of a coordinate.
 */
interface Latitude: GeoLine

/**
 * Longitude/meridian position of a coordinate.
 */
interface Longitude: GeoLine

@JvmInline
internal value class DecimalLatitude(override val asDecimal: Double): Latitude {
    override val degreesComponent: Int get() = asDecimal.degreesComponent
    override val minutesComponent: Int get() = asDecimal.minutesComponent
    override val secondsComponent: Float get() = asDecimal.secondsComponent
    override val cardinal: Cardinal get() = if (asDecimal > 0) Cardinal.North else Cardinal.South
    override fun toString(): String = asDecimal.toString()
}

@JvmInline
internal value class DecimalLongitude(override val asDecimal: Double): Longitude {
    override val degreesComponent: Int get() = asDecimal.degreesComponent
    override val minutesComponent: Int get() = asDecimal.minutesComponent
    override val secondsComponent: Float get() = asDecimal.secondsComponent
    override val cardinal: Cardinal get() = if (asDecimal > 0) Cardinal.East else Cardinal.West
    override fun toString(): String = asDecimal.toString()
}

internal data class DmsLatitude(
    override val degreesComponent: Int,
    override val minutesComponent: Int,
    override val secondsComponent: Float,
    override val cardinal: Cardinal,
): Latitude {
    override val asDecimal: Double get() = toDecimal(
        degrees = degreesComponent,
        minutes = minutesComponent,
        seconds = secondsComponent,
        cardinal = cardinal,
    )
    override fun toString(): String = "${degreesComponent}º${minutesComponent}\"${secondsComponent}'${cardinal}"
}
internal data class DmsLongitude(
    override val degreesComponent: Int,
    override val minutesComponent: Int,
    override val secondsComponent: Float,
    override val cardinal: Cardinal,
): Longitude {
    override val asDecimal: Double get() = toDecimal(
        degrees = degreesComponent,
        minutes = minutesComponent,
        seconds = secondsComponent,
        cardinal = cardinal,
    )
    override fun toString(): String = "${degreesComponent}º${minutesComponent}\"${secondsComponent}'${cardinal}"
}

/**
 * Express a latitude line from decimal degrees.
 */
val Number.latitude: Latitude get() = DecimalLatitude(toDouble())

/**
 * Express a longitude line from decimal degrees.
 */
val Number.longitude: Longitude get() = DecimalLongitude(toDouble())

/**
 * Create a geoline from a degrees/minutes/seconds and cardinal
 */
fun geoLineOf(
    degreesComponent: Int,
    minutesComponent: Int,
    secondsComponent: Float,
    cardinal: Cardinal,
): GeoLine = when (cardinal) {
    Cardinal.North, Cardinal.South -> DmsLatitude(degreesComponent, minutesComponent, secondsComponent, cardinal)
    Cardinal.East, Cardinal.West -> DmsLongitude(degreesComponent, minutesComponent, secondsComponent, cardinal)
}

/**
 * Create a latitude from a degrees/minutes/seconds and a cardinal.
 *
 * @see latitude to convert a decimal format instead.
 */
fun latitudeOf(
    degreesComponent: Int,
    minutesComponent: Int,
    secondsComponent: Float,
    cardinal: Cardinal,
): Latitude = when (cardinal) {
    Cardinal.North, Cardinal.South -> DmsLatitude(degreesComponent, minutesComponent, secondsComponent, cardinal)
    Cardinal.East, Cardinal.West -> throw IllegalArgumentException("Cardinal <$cardinal> is invalid for a latitude line")
}

/**
 * Create a logitude from a degrees/minutes/seconds and a cardinal.
 *
 * @see longitude to convert a decimal format instead.
 */
fun longitudeOf(
    degreesComponent: Int,
    minutesComponent: Int,
    secondsComponent: Float,
    cardinal: Cardinal,
): Longitude = when (cardinal) {
    Cardinal.North, Cardinal.South -> throw IllegalArgumentException("Cardinal <$cardinal> is invalid for a longitude line")
    Cardinal.East, Cardinal.West -> DmsLongitude(degreesComponent, minutesComponent, secondsComponent, cardinal)
}
