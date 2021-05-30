package inkapplications.spondee.measures

import org.junit.Test
import kotlin.test.assertEquals

class RatioTest {
    @Test
    fun math() {
        assertEquals(Ratio(A(1.0), B(2.0)), A(1.0) per B(2.0))
        assertEquals(A(15.0), (A(5.0) per B(20.0)) * B(60.0))
        assertEquals(A(10.0), (A(2.0) per Square(B(2.0))) * Square(B(10.0)))
    }
}
