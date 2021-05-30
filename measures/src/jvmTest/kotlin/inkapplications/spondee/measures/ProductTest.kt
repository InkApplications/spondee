package inkapplications.spondee.measures

import org.junit.Test
import kotlin.test.assertEquals

class ProductTest {
    @Test
    fun math() {
        assertEquals(A(1.5), (A(2.0) * B(3.0)) / B(4.0))
    }
}
