package inkapplications.spondee.measures

/**
 * Latitude/Longitude position data.
 */
data class GeoCoordinates(
    val latitude: Latitude,
    val longitude: Longitude,
) {
    override fun toString(): String = "lat: $latitude lng: $longitude"
}
