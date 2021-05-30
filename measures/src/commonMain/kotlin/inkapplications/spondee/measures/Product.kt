package inkapplications.spondee.measures

/**
 * Result of two units multiplied as a composite.
 */
data class Product<A, B>(val left: A, val right: B)

operator fun <A: DoubleMeasure<A>, P: DoubleMeasure<P>, B: P, C: P> Product<A, B>.div(c: C): A {
    return c.pow(-1) * (left * right)
}
