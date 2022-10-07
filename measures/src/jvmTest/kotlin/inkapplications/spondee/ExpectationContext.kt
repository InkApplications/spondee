package inkapplications.spondee

data class ExpectationContext<T>(
    val expected: T
)

inline fun <T> withExpectation(expected: T, assertions: ExpectationContext<T>.() -> Unit) {
    assertions(ExpectationContext(expected))
}
