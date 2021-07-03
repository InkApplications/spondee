package inkapplications.spondee.spatial

import inkapplications.spondee.testConvert
import org.junit.Test
import java.lang.Math.PI
import kotlin.test.assertEquals

class AngleTest {
    @Test
    fun conversions() {
        testConvert(0, Radians) {
            equals(0, Degrees)
        }
        testConvert(PI, Radians) {
            equals(180, Degrees)
        }
    }

    @Test
    fun formats() {
        assertEquals("0.0", Radians.of(0).let { Radians.format(it) })
        assertEquals("0.0º", Degrees.of(0).let { Degrees.format(it) })
    }

    @Test
    fun cardinals() {
        assertEquals(Cardinal.West, Degrees.of(316).toNearestCardinal())
        assertEquals(Cardinal.North, Degrees.of(0).toNearestCardinal())
        assertEquals(Cardinal.North, Degrees.of(5).toNearestCardinal())
        assertEquals(Cardinal.North, Degrees.of(45).toNearestCardinal())

        assertEquals(Cardinal.East, Degrees.of(46).toNearestCardinal())
        assertEquals(Cardinal.East, Degrees.of(90).toNearestCardinal())
        assertEquals(Cardinal.East, Degrees.of(95).toNearestCardinal())
        assertEquals(Cardinal.East, Degrees.of(135).toNearestCardinal())

        assertEquals(Cardinal.South, Degrees.of(136).toNearestCardinal())
        assertEquals(Cardinal.South, Degrees.of(180).toNearestCardinal())
        assertEquals(Cardinal.South, Degrees.of(185).toNearestCardinal())
        assertEquals(Cardinal.South, Degrees.of(225).toNearestCardinal())

        assertEquals(Cardinal.West, Degrees.of(226).toNearestCardinal())
        assertEquals(Cardinal.West, Degrees.of(270).toNearestCardinal())
        assertEquals(Cardinal.West, Degrees.of(275).toNearestCardinal())
        assertEquals(Cardinal.West, Degrees.of(315).toNearestCardinal())
    }
}
