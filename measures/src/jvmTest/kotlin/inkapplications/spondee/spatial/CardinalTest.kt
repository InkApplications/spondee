package inkapplications.spondee.spatial

import org.junit.Test
import kotlin.test.assertEquals

class CardinalTest {
    @Test
    fun toAngle() {
        assertEquals(0.degrees, Cardinal.North.toAngle())
        assertEquals(90.degrees, Cardinal.East.toAngle())
        assertEquals(180.degrees, Cardinal.South.toAngle())
        assertEquals(270.degrees, Cardinal.West.toAngle())
    }
}
