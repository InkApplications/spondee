package sik.math

/**
 * Represents a percentage value.
 *
 * This uses a double whole digit representation of the percentage to
 * make operations involving percentages more clear.
 *
 * @see Number.percent to create a percentage from a while number (ex. `55`)
 * @see Float.toPercentage to create a percentage from a fractional value (ex. `.55F`)
 * @see Double.toPercentage to create a percentage from a fractional value (ex. `.55`)
 */
data class Percentage(val value: Double): Number() {
    /**
     * Get the percentage as a fractional decimal instead of a whole number.
     */
    fun asFraction(): Double = value / 100

    override fun toByte(): Byte = value.toInt().toByte()
    override fun toChar(): Char = value.toChar()
    override fun toDouble(): Double = value
    override fun toFloat(): Float = value.toFloat()
    override fun toInt(): Int = value.toInt()
    override fun toLong(): Long = value.toLong()
    override fun toShort(): Short = value.toInt().toShort()
    operator fun times(other: Number): Double = asFraction().times(other.toDouble())
    operator fun div(other: Number): Double = asFraction().div(other.toDouble())
    operator fun rem(other: Number) = asFraction().rem(other.toDouble())

    operator fun plus(other: Byte): Percentage = copy(value = value.plus(other))
    operator fun plus(other: Char): Percentage = copy(value = value.plus(other.toInt()))
    operator fun plus(other: Double): Percentage = copy(value = value.plus(other))
    operator fun plus(other: Float): Percentage = copy(value = value.plus(other))
    operator fun plus(other: Int): Percentage = copy(value = value.plus(other))
    operator fun plus(other: Long): Percentage = copy(value = value.plus(other))
    operator fun plus(other: Short): Percentage = copy(value = value.plus(other))
    operator fun plus(other: Number): Percentage = copy(value = value.plus(other.toDouble()))

    operator fun minus(other: Byte): Percentage = copy(value = value.minus(other))
    operator fun minus(other: Char): Percentage = copy(value = value.minus(other.toInt()))
    operator fun minus(other: Double): Percentage = copy(value = value.minus(other))
    operator fun minus(other: Float): Percentage = copy(value = value.minus(other))
    operator fun minus(other: Int): Percentage = copy(value = value.minus(other))
    operator fun minus(other: Long): Percentage = copy(value = value.minus(other))
    operator fun minus(other: Short): Percentage = copy(value = value.minus(other))
    operator fun minus(other: Number): Percentage = copy(value = value.minus(other.toDouble()))

    operator fun compareTo(other: Byte): Int = value.compareTo(other)
    operator fun compareTo(other: Char): Int = value.compareTo(other.toInt())
    operator fun compareTo(other: Double): Int = value.compareTo(other)
    operator fun compareTo(other: Float): Int = value.compareTo(other)
    operator fun compareTo(other: Int): Int = value.compareTo(other)
    operator fun compareTo(other: Long): Int = value.compareTo(other)
    operator fun compareTo(other: Short): Int = value.compareTo(other)
    operator fun compareTo(other: Number): Int = value.compareTo(other.toDouble())

    operator fun unaryPlus() = this
    operator fun unaryMinus() = copy(value = -value)

    operator fun inc() = plus(1)
    operator fun dec() = minus(1)

    /**
     * Shorthand readable syntax for multiplying.
     *
     * ex:
     *     50.percent of 100
     */
    infix fun of(other: Number) = times(other)

    override fun toString(): String = "$value%"
}

/**
 * Express a percentage as a whole number.
 *
 * This is a whole number, not a fraction!
 * ex. `55.percent` is 55% or 0.55
 *
 * @see toPercentage to convert a fractional value such as `.55`
 */
val Number.percent: Percentage get() = Percentage(toDouble())

/**
 * Express with a fractional percentage.
 *
 * This is a fraction value, not a whole percentage!
 * ex: `0.55f.asPercentage` is 55%
 *
 * @see percent to convert a whole percentage value.
 */
fun Float.toPercentage(): Percentage = (toDouble() * 100).percent

/**
 * Express with a fractional percentage.
 *
 * This is a fraction value, not a whole percentage!
 * ex: `0.55f.asPercentage` is 55%
 *
 * @see percent to convert a whole percentage value.
 */
fun Double.toPercentage(): Percentage = (toDouble() * 100).percent
