/*  Integral Calculator
    @author Gjin Rexhaj
    @version 1.0
    @since 2/1/2024

    Calculates the integrals of quadratic equations within a specified tolerance. Uses DigitCounter.java as a support class

*/

import java.util.Scanner;
import java.lang.Math;

/** {@code IntegralCalculator} uses {@code DigitCounter} as a support class.*/
public class IntegralCalculator {

  // accepts a, b, c; returns the value of F(x)
  public static double quadratic(double firstTerm, double secondTerm, double thirdTerm, double xValue) {
    double calculation;
    calculation = (firstTerm * xValue * xValue) + (secondTerm * xValue) + thirdTerm;
    return calculation;
  }

  // accepts a, b, c, left, right, bins; returns the left Riemann sum
  public static double leftRiemannSum(double firstTerm, double secondTerm, double thirdTerm, double left, double right, int bins) {
    // initialize incrementor for do loop, final riemann sum double variable,
    // declare binWidth, and left
    double leftRiemannSum = 0;
    double leftOrRight = left;
    double binWidth;

    binWidth = (right - left) / bins;

    // do loop, calculates left riemann sum
    do {
      leftRiemannSum += quadratic(firstTerm, secondTerm, thirdTerm, leftOrRight) * binWidth;
      leftOrRight += binWidth;
    } while (leftOrRight < right);
    return leftRiemannSum;
  }

  /** Main Method executes code- uses {@code leftRiemannSum} method and {@code DigitCounter} class.*/
  public static void main(String[] args) {
    // declare a, b, and c values of quadratic formula, as well as left/right intervals, tolerance,
    // and initialize prev/current area and bins value (for tolerance calculation)
    double firstValue, secondValue, thirdValue, leftValue, rightValue, tolerance;
    double prevArea = 0;
    double currArea = 0;
    int binsValue = 1;
    int decimalPlaces;

    // sets sentinel value for while loop which calculates area
    int loopCondition = 1;

    //prompt the user for input, a, b, c, intervals, and tolerance
    Scanner scanValues = new Scanner(System.in);

    System.out.println("Quadratic Formula: ax^2 + bx + c");
    System.out.print("Enter 'a' value: ");
    firstValue = scanValues.nextDouble();
    System.out.print("Enter 'b' value: ");
    secondValue = scanValues.nextDouble();
    System.out.print("Enter 'c' value: ");
    thirdValue = scanValues.nextDouble();
    System.out.print("Enter the left value of the interval: ");
    leftValue = scanValues.nextDouble();
    System.out.print("Enter the right value of the interval: ");
    rightValue = scanValues.nextDouble();
    System.out.print("Specify tolerance: ");
    tolerance = scanValues.nextDouble();

    // close scanner to prevent memory leak
    scanValues.close();

    // sets the appropriate number of bins given the specified tolerance
    // and uses LeftRiemannSum to calculate area
    while (loopCondition == 1) {
      currArea = leftRiemannSum(firstValue, secondValue, thirdValue, leftValue, rightValue, binsValue);

      //exit loop if the tolerance exceeds the difference between current and previous area
      if (Math.abs(currArea - prevArea) < tolerance) {
        loopCondition = 2;
      }
      binsValue++;
      prevArea = currArea;
    }

    //use DigitCounter support class to determine the amount of decimal places in tolerance
    decimalPlaces = DigitCounter.decimals(tolerance);

    //print out initial line announcing bin values and area
    System.out.print("Left Riemann Sum with " + binsValue + " bins = ");

    // set format in accordance with the amount of deicmal places present in tolerance,
    // and print formatted output
    String format = "%." + decimalPlaces + "f";
    System.out.printf(format, currArea);
  }
}
