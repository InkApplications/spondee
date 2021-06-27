package inkapplications.spondee.structure

abstract class StoredUnit<M: DoubleMeasurement<M>>: DoubleUnit<M> {
    final override fun convertValue(value: M): Double = value.rawValue
}
