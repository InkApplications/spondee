package inkapplications.spondee.spatial

import org.junit.Test
import kotlin.test.assertEquals

class CardinalTest {
    @Test
    fun toAngle() {
        assertEquals(Degrees.of(0), Cardinal.North.toAngle())
        assertEquals(Degrees.of(90), Cardinal.East.toAngle())
        assertEquals(Degrees.of(180), Cardinal.South.toAngle())
        assertEquals(Degrees.of(270), Cardinal.West.toAngle())
    }
}
