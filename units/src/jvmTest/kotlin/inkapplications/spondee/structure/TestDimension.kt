package inkapplications.spondee.structure

@JvmInline
value class TestDimension(override val value: Number): Dimension<TestDimension> {
    override fun withValue(value: Number): TestDimension = TestDimension(value)
    override val symbol: String get() = "T"
    override fun toString(): String = "$value$symbol"
}
