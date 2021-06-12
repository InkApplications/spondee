package inkapplications.spondee.structure

import kotlin.jvm.JvmInline

/**
 * Wrapper for a typeless scaling SI value.
 */
@JvmInline
value class SiValue(val baseValue: Double) {
    val inYottas get() = baseValue / 1e24
    val inZettas get() = baseValue / 1e21
    val inExas get() = baseValue / 1e18
    val inPetas get() = baseValue / 1e15
    val inTeras get() = baseValue / 1e12
    val inGigas get() = baseValue / 1e9
    val inMegas get() = baseValue / 1e6
    val inKilos get() = baseValue / 1e3
    val inHectos get() = baseValue / 1e2
    val inDekas get() = baseValue / 1e1
    val inDecis get() = baseValue / 1e-1
    val inCentis get() = baseValue / 1e-2
    val inMillis get() = baseValue / 1e-3
    val inMicros get() = baseValue / 1e-6
    val inNanos get() = baseValue / 1e-9
    val inPicos get() = baseValue / 1e-12
    val inFemtos get() = baseValue / 1e-15
    val inAttos get() = baseValue / 1e-18
    val inZeptos get() = baseValue / 1e-21
    val inYoctos get() = baseValue / 1e-24
}

val Number.yotta get() = SiValue(toDouble() * 1e24)
val Number.zetta get() = SiValue(toDouble() * 1e21)
val Number.exa get() = SiValue(toDouble() * 1e18)
val Number.peta get() = SiValue(toDouble() * 1e15)
val Number.tera get() = SiValue(toDouble() * 1e12)
val Number.giga get() = SiValue(toDouble() * 1e9)
val Number.mega get() = SiValue(toDouble() * 1e6)
val Number.kilo get() = SiValue(toDouble() * 1e3)
val Number.hecto get() = SiValue(toDouble() * 1e2)
val Number.deka get() = SiValue(toDouble() * 1e1)
val Number.deci get() = SiValue(toDouble() * 1e-1)
val Number.centi get() = SiValue(toDouble() * 1e-2)
val Number.milli get() = SiValue(toDouble() * 1e-3)
val Number.micro get() = SiValue(toDouble() * 1e-6)
val Number.nano get() = SiValue(toDouble() * 1e-9)
val Number.pico get() = SiValue(toDouble() * 1e-12)
val Number.femto get() = SiValue(toDouble() * 1e-15)
val Number.atto get() = SiValue(toDouble() * 1e-18)
val Number.zepto get() = SiValue(toDouble() * 1e-21)
val Number.yocto get() = SiValue(toDouble() * 1e-24)
