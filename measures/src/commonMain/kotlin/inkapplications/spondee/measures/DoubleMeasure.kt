package inkapplications.spondee.measures

import kotlin.math.pow

/**
 * A generic type of measurement.
 *
 * Implementing this interface will provide math extensions on the unit's
 * value while preserving the parent unit type.
 *
 * @param T The parent unit for which math operations return.
 */
interface DoubleMeasure<T> {
    /**
     * Convert a value of the same measurement type into the units of this type.
     *
     * This is used for math operations to coalesce two values into the same
     * unit type.
     *
     * @param value the unit to be converted to the same type as `this`.
     * @return the raw value of [value] in this unit's measure.
     */
    fun convert(value: T): Double

    /**
     * Create a new instance of this unit.
     *
     * This is used as a copy constructor in generic math operations.
     *
     * @param value The value to be expressed in this value's unit.
     */
    fun create(value: Double): T
}

operator fun <A: DoubleMeasure<A>> A.unaryPlus(): A = this
operator fun <A: DoubleMeasure<A>> A.unaryMinus(): A {
    return create(-convert(this))
}

fun <A: DoubleMeasure<A>> A.pow(exponent: Number): A {
    return create(convert(this).pow(exponent.toDouble()))
}

operator fun <A: DoubleMeasure<A>> A.compareTo(other: A): Int {
    return convert(this).compareTo(convert(other))
}
operator fun <A: DoubleMeasure<A>> A.plus(other: A): A {
    return create(convert(other) + convert(this))
}

operator fun <A: DoubleMeasure<A>> A.div(other: Number): A {
    return create(convert(this) / other.toDouble())
}

operator fun <A: DoubleMeasure<A>> A.times(other: Number): A {
    return create(convert(this) * other.toDouble())
}

operator fun <A: DoubleMeasure<A>> A.minus(other: A): A {
    return create(convert(this) - convert(other))
}

operator fun <A: DoubleMeasure<A>, B: DoubleMeasure<B>> B.times(other: Product<A, B>): A {
    return other.left * convert(other.right) * convert(this)
}

operator fun <A: DoubleMeasure<A>, B: DoubleMeasure<B>> A.times(other: B): Product<A, B> {
    return Product(this, other)
}
