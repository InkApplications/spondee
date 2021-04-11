package inkapplications.spondee.measures

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GeoLineTest {
    @Test
    fun fromDecimal() {
        val latitude = 37.778667.latitude
        val longitude = (-84.036500).longitude

        assertEquals(37, latitude.degreesComponent)
        assertEquals(46, latitude.minutesComponent)
        assertEquals(43.2012f, latitude.secondsComponent)
        assertEquals(Cardinal.North, latitude.cardinal)

        assertEquals(84, longitude.degreesComponent)
        assertEquals(2, longitude.minutesComponent)
        assertEquals(11.4f, longitude.secondsComponent)
        assertEquals(Cardinal.West, longitude.cardinal)
    }

    @Test
    fun fromDegrees() {
        val latitude = latitudeOf(37, 46, 43.2012f, Cardinal.North)
        val longitude = longitudeOf(84, 2, 11.4f, Cardinal.West)

        assertTrue(37.778667 - latitude.asDecimal < .0001)
        assertTrue(-84.0365 - longitude.asDecimal < .0001)
    }

    @Test(expected = IllegalArgumentException::class)
    fun notLatitude() {
        latitudeOf(37, 46, 43.2012f, Cardinal.West)
    }

    @Test(expected = IllegalArgumentException::class)
    fun notLongitude() {
        longitudeOf(84, 2, 11.4f, Cardinal.North)
    }
}
