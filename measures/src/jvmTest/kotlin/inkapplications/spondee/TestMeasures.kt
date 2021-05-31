package inkapplications.spondee.measure

import inkapplications.spondee.structure.DoubleMeasure

data class A(val value: Double): DoubleMeasure<A> {
    override fun convert(value: A): Double = value.value
    override fun create(value: Double): A = A(value)
}

data class B(val value: Double): DoubleMeasure<B> {
    override fun convert(value: B): Double = value.value
    override fun create(value: Double): B = B(value)
}
