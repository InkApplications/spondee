Spondee
=======

A class set for wrapping units of measure in an application.

FAQ
---

### What is this?
A collection of classes representing units of measure that can be used
in an application.

### Why not use a plain number type?
Plain numbers are often ambiguous. Consider the method:

    fun setLight(brightness: Number)

What number would you pass in to set the light to half brightness?

### What measurement systems does this use?

Measurements are done in US Customary and Metric Units by default.
If you need a different system, units can easily be extended provided they
can be adapted to match the measurement's interface and converted to a
reference unit.

### Is this a comprehensive set of units?
Absolutely not. Feel free to add them.

### What is the worst unit?
You would think it'd be Ounces, but it's actually Bels.

### Are these optimized for efficiency?
No. Math on these units are often done with Double precision. If this is
a problem in your application, they can be converted to a plain number for
efficiency. In reality, though, it's probably fine.

Design Rules
------------

Here are some rules that are followed on this project. If you contribute,
please follow them.

 - Units should be value classes where possible
 - Values should prefer `Double` values when performing math and transformation
   operations.

