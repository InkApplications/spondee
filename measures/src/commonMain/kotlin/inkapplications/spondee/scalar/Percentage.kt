package inkapplications.spondee.scalar

import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Unit wrapper for a percentage value
 */
interface Percentage {
    fun toDecimal(): DecimalPercentage
}

/**
 * Percentage value expressed as a decimal.
 */
@JvmInline
value class DecimalPercentage(override val value: Number): Percentage, Dimension<DecimalPercentage> {
    override val symbol: String get() = ""
    override fun toDecimal(): DecimalPercentage = this
    override fun withValue(value: Number): DecimalPercentage = DecimalPercentage(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a percentage where 1 is considered 100%.
 */
val Number.decimalPercentage get() = DecimalPercentage(this)

/**
 * Percentage value expressed in whole numbers.
 */
@JvmInline
value class WholePercentage(override val value: Number): Percentage, Dimension<WholePercentage> {
    override fun toDecimal(): DecimalPercentage = value.toDouble().div(100).decimalPercentage
    override fun withValue(value: Number): WholePercentage = WholePercentage(value)
    override val symbol: String get() = "%"
    override fun toString(): String = format()
}

/**
 * Express this number as a percentage where 100 is 100%
 */
val Number.percent get() = WholePercentage(this)

/**
 * Convert the percentage to a whole percentage value (0-100)
 */
fun Percentage.toWholePercentage() = toDecimal().value.toDouble().times(100).percent
