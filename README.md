Spondee
=======

A class set for wrapping units of measure and common data structures in
a Kotlin application.

FAQ
---

### What is this?
A collection of classes representing units of measure and other common
data containers that can be used in an application.

### Why not use a plain number type?
Plain numbers are often ambiguous. Consider the method:

    fun setLight(brightness: Number)

What number would you pass in to set the light to half brightness?

### What measurement systems does this use?
For measurements, both Metric and US Customary systems are typically
implemented. You can also easily add new units by implementing the
type's interface. This typically only requires the ability to convert
to a common unit, and will allow the new unit to be easily converted
between units of the same type.

### Is this a comprehensive set of units?
There are many ways to measure things and store data.
This will never be comprehensive, but is designed to be extensible instead.
Feel free to add units that you use.

### Why are some units represented as ratios and some have their own definition?
Relying only on base units and composing the unit definitions was
considered for the design of this project. However, while technically correct,
it made using and maintaining the library cumbersome. It also relied more on
math transformations, which increased floating point issues.

This library is designed so that values can be simply annotated by a wrapping
value class, maintaining its original number type.

In practice, units that are expressed as ratios, such as kilometers per hour,
should rely on the `Ratio` type. Units that are given a name should get their
own types, even if they are technically composed from other units.

### What is the worst unit?
You would think it'd be Ounces, but it's actually Bels.

### Are these optimized for efficiency?
No. Math on these units are often done with Double precision. If this is
a problem in your application, they can be converted to a plain number for
efficiency. In reality, though, it's probably fine.
