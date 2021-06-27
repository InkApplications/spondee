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

### Is this a comprehensive set of units?
Absolutely not. Feel free to add them.

### What is the worst unit?
Bels.

### Are these optimized for efficiency?
No. Math on these units are often done with Double precision. If this is
a problem in your application, they can be converted to a plain number for
efficiency. In reality, though, it's probably fine.

Design Rules
------------

Here are some rules that are followed on this project. If you contribute,
please follow them.

 - Units should be value classes where possible
 - Values should prefer `Double` values for storage

