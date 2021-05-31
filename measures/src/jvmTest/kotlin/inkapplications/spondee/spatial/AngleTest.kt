package inkapplications.spondee.spatial

import inkapplications.spondee.spatial.degrees
import inkapplications.spondee.spatial.radians
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
}
