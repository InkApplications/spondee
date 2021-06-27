package inkapplications.spondee.structure

abstract class BaseUnit<M: Measurement<M>>: MeasurementUnit<M> {
    final override fun convertValue(value: M): Double = value.baseValue
}
