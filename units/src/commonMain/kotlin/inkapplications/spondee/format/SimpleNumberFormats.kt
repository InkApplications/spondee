package inkapplications.spondee.format

/**
 * Denotes naive implementations of number formatting custom built for spondee.
 *
 * Kotlin Multiplatform currently has no number formatter implementation.
 * This is particularly a problem for formatters within this library.
 * Should a number formatter be implemented in Kotlin multiplatform that
 * this library can be used instead, these will quickly become deprecated in
 * favor of a more thorough implementation.
 *
 * For now, this annotation is to warn that these implementations are simplistic
 * as to only solve the problems that this library has, and are not necessarily
 * meant to be flexible or maintained long-term.
 *
 * @see https://youtrack.jetbrains.com/issue/KT-21644
 */
@MustBeDocumented
@RequiresOptIn(
    message = "This will become deprecated if Kotlin implements number formatting.",
    level = RequiresOptIn.Level.WARNING,
)
annotation class SimpleNumberFormats
