package inkapplications.spondee.structure

interface Measurement<T: Measurement<T>>

interface DoubleMeasurement<T: DoubleMeasurement<T>>: Measurement<T>, Comparable<DoubleMeasurement<T>> {
    val rawValue: Double
    val storedUnit: DoubleUnit<T>
    override fun compareTo(other: DoubleMeasurement<T>): Int = rawValue.compareTo(other.rawValue)
}

fun <T: DoubleMeasurement<T>> T.value(unit: DoubleUnit<T>): Double = unit.convertValue(this)
fun <T: DoubleMeasurement<T>> T.value(scale: SiScale, unit: DoubleUnit<T>): Double = unit.convertValue(this) / scale.factor

operator fun <T: DoubleMeasurement<T>> T.rem(other: T): T {
    return storedUnit.of(rawValue % other.rawValue)
}
operator fun <T: DoubleMeasurement<T>> T.compareTo(other: T): Int {
    return rawValue.compareTo(other.rawValue)
}
operator fun <T: DoubleMeasurement<T>> T.plus(other: T): T {
    return storedUnit.of(rawValue + other.rawValue)
}
operator fun <T: DoubleMeasurement<T>> T.minus(other: T): T {
    return storedUnit.of(rawValue - other.rawValue)
}
operator fun <T: DoubleMeasurement<T>> T.times(multiplier: Number): T {
    return storedUnit.of(rawValue * multiplier.toDouble())
}
operator fun <T: DoubleMeasurement<T>> T.div(divisor: Number): T {
    return storedUnit.of(rawValue / divisor.toDouble())
}
