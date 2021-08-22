package inkapplications.spondee.format

import org.junit.Test
import kotlin.test.assertEquals

@OptIn(SimpleNumberFormats::class)
class NumberFormatTest {
    @Test
    fun format() {
        assertEquals("2", 2.345f.formatDecimal())
        assertEquals("2.34", 2.341f.formatDecimal(2))
        assertEquals("2.35", 2.345f.formatDecimal(2))
        assertEquals("0.12", .123f.formatDecimal(2))
    }
}
