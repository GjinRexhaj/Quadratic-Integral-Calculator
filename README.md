# QUADRATIC INTEGRAL CALCULATOR
This is a relatively simple command-line application, which calculates the integral of a quadratic function over an interval with varying levels of precision depending on the specified tolerance.

To run this program on Windows, download IntegralCalculator.jar and open command prompt.
Then, type the follow with your specified download path:
```
java -jar <Your-downloads-path>\IntegralCalculator.jar
```
With my current setup I run it with
```
java -jar C:\Users\Gjin\Downloads\IntegralCalculator.jar
```
After you download the file, you can move it anywhere and run it as long as you specify the path where it resides.


## IntegralCalculator.java
Driver class which contains main(), leftRiemannSum(), and quadratic() methods.

## DigitCounter.java 
Support class which contains overloaded methods of int, float, double, and String. The digits() method returns the number of digits left of the decimal point, while the decimals() method returns the number of digits right of the decimal point.
