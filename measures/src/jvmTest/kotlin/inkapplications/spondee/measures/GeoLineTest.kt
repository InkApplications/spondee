package inkapplications.spondee.measures

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GeoLineTest {
    @Test
    fun fromDecimal() {
        val latitude = Latitude(37.778667)
        val longitude = Longitude(-84.036500)

        assertEquals(37, latitude.degrees)
        assertEquals(46, latitude.minutes)
        assertEquals(43.2012f, latitude.seconds)
        assertEquals(Cardinal.North, latitude.cardinal)

        assertEquals(84, longitude.degrees)
        assertEquals(2, longitude.minutes)
        assertEquals(11.4f, longitude.seconds)
        assertEquals(Cardinal.West, longitude.cardinal)
    }

    @Test
    fun fromDegrees() {
        val latitude = Latitude(37, 46, 43.2012f, Cardinal.North)
        val longitude = Longitude(84, 2, 11.4f, Cardinal.West)

        assertTrue(37.778667 - latitude.decimal < .0001)
        assertTrue(-84.0365 - longitude.decimal < .0001)
    }
}
