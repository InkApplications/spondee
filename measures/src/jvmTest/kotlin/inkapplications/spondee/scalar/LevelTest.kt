package inkapplications.spondee.scalar

import inkapplications.spondee.scalar.bels
import kotlin.test.Test
import kotlin.test.assertEquals

class LevelTest {
    @Test
    fun formats() {
        assertEquals("123B", 123.bels.toString())
    }
}
