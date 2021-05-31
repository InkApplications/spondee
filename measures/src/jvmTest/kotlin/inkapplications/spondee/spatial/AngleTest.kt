package inkapplications.spondee.spatial

import org.junit.Test
import java.lang.Math.PI
import kotlin.test.assertEquals

class AngleTest {
    @Test
    fun conversions() {
        assertEquals(0.0, 0.degrees.inRadians)
        assertEquals(PI, 180.degrees.inRadians)
        assertEquals(0.0, 0.radians.inDegrees)
        assertEquals(180.0, PI.radians.inDegrees)
    }

    @Test
    fun cardinals() {
        assertEquals(Cardinal.West, 316.degrees.toNearestCardinal())
        assertEquals(Cardinal.North, 0.degrees.toNearestCardinal())
        assertEquals(Cardinal.North, 5.degrees.toNearestCardinal())
        assertEquals(Cardinal.North, 45.degrees.toNearestCardinal())

        assertEquals(Cardinal.East, 46.degrees.toNearestCardinal())
        assertEquals(Cardinal.East, 90.degrees.toNearestCardinal())
        assertEquals(Cardinal.East, 95.degrees.toNearestCardinal())
        assertEquals(Cardinal.East, 135.degrees.toNearestCardinal())

        assertEquals(Cardinal.South, 136.degrees.toNearestCardinal())
        assertEquals(Cardinal.South, 180.degrees.toNearestCardinal())
        assertEquals(Cardinal.South, 185.degrees.toNearestCardinal())
        assertEquals(Cardinal.South, 225.degrees.toNearestCardinal())

        assertEquals(Cardinal.West, 226.degrees.toNearestCardinal())
        assertEquals(Cardinal.West, 270.degrees.toNearestCardinal())
        assertEquals(Cardinal.West, 275.degrees.toNearestCardinal())
        assertEquals(Cardinal.West, 315.degrees.toNearestCardinal())
    }
}
