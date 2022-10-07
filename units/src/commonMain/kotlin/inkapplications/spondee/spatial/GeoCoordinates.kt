package inkapplications.spondee.spatial

/**
 * Latitude/Longitude position data.
 */
data class GeoCoordinates(
    val latitude: Latitude,
    val longitude: Longitude,
) {
    override fun toString(): String = "[$latitude, $longitude]"
}
