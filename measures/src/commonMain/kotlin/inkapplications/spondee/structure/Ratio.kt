package inkapplications.spondee.structure

/**
 * An expression of ratio between two numbers, preserving their type information.
 */
data class Ratio<N, D>(val numerator: N, val denominator: D)

/**
 * Create a ratio.
 */
infix fun <N, D> N.per(denominator: D) = Ratio(this, denominator)

operator fun <N: DoubleMeasure<N>, D: DoubleMeasure<D>> Ratio<N, D>.times(area: D): N {
    return (numerator * area)/denominator
}

operator fun <N: DoubleMeasure<N>, D: DoubleMeasure<D>> Ratio<N, Square<D>>.times(area: Square<D>): N {
    return (numerator * area.width)/denominator.width
}
