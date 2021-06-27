package inkapplications.spondee.structure

interface MeasurementUnit<M: Measurement<M>> {
    fun convertValue(value: M): Double
    fun of(value: Number): M
}
