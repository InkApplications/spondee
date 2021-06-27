package inkapplications.spondee.structure

import kotlin.jvm.JvmInline

@JvmInline
value class SiScale(val factor: Double)

val Yotta = SiScale(1e24)
val Zetta = SiScale(1e21)
val Exa = SiScale(1e18)
val Peta = SiScale(1e15)
val Tera = SiScale(1e12)
val Giga = SiScale(1e9)
val Mega = SiScale(1e6)
val Kilo = SiScale(1e3)
val Hecto = SiScale(1e2)
val Deka = SiScale(1e1)
val Deci = SiScale(1e-1)
val Centi = SiScale(1e-2)
val Milli = SiScale(1e-3)
val Micro = SiScale(1e-6)
val Nano = SiScale(1e-9)
val Pico = SiScale(1e-12)
val Femto = SiScale(1e-15)
val Atto = SiScale(1e-18)
val Zepto = SiScale(1e-21)
val Yocto = SiScale(1e-24)
