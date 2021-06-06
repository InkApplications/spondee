package inkapplications.spondee.structure

/**
 * Result of two units multiplied as a composite.
 */
data class Product<A, B>(val left: A, val right: B)

operator fun <A: DoubleMeasure<A>, B: DoubleMeasure<B>> Product<A, B>.div(other: B): A {
    return left.create((left.convert(left) * right.convert(right)) / right.convert(other))
}
