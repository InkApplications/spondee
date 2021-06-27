package inkapplications.spondee.structure

interface Measurement<T: Measurement<T>> {
    val rawValue: Double
    val storedUnit: MeasurementUnit<T>
}

fun <T: Measurement<T>> T.value(unit: MeasurementUnit<T>): Double = unit.convertValue(this)
fun <T: Measurement<T>> T.value(scale: SiScale, unit: MeasurementUnit<T>): Double = unit.convertValue(this) / scale.factor

operator fun <T: Measurement<T>> T.rem(other: T): T {
    return storedUnit.of(rawValue % other.rawValue)
}
operator fun <T: Measurement<T>> T.compareTo(other: T): Int {
    return rawValue.compareTo(other.rawValue)
}
operator fun <T: Measurement<T>> T.plus(other: T): T {
    return storedUnit.of(rawValue + other.rawValue)
}
operator fun <T: Measurement<T>> T.minus(other: T): T {
    return storedUnit.of(rawValue - other.rawValue)
}
operator fun <T: Measurement<T>> T.times(multiplier: Number): T {
    return storedUnit.of(rawValue * multiplier.toDouble())
}
operator fun <T: Measurement<T>> T.div(divisor: Number): T {
    return storedUnit.of(rawValue / divisor.toDouble())
}
