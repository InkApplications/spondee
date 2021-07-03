package inkapplications.spondee.measure

import inkapplications.spondee.structure.times
import kotlin.test.Test
import kotlin.test.assertEquals

class LevelTest {
    @Test
    fun formats() {
        assertEquals("0.0B", Bels.of(0).let { Bels.format(it) })
    }
}
