/*  DigitCounter Class
    Author: Gjin Rexhaj
    Date: 1/30/2024

    Acts as a support class which contains methods that
    return numbers left and right of the decimal points

*/

/** DigitCounter Support Class contains four overloaded methods 
 * for digit numbers and decimal numbers.*/
public class DigitCounter {

  //-----------------------------------------------------------------------------------
  // overloaded Digits method return the number of digits LEFT of the decimal point
  //-----------------------------------------------------------------------------------
  /** Method which returns the number of digits in an integer. */
  public static int digits(int number) {
    // convert int to string
    String stringNumber = Integer.toString(number);
    // use String.split() method to split string by decimal point and
    // store left/right digits into parts array
    String[] parts = stringNumber.split("\\.");
    // set int numOfDigits = the length of digits left of the decimal point
    int numOfDigits = parts[0].length();
    // return number of digits as an int
    return numOfDigits;
  }
  
  /** Method which returns the number of digits in a float. */
  public static int digits(float number) {
    // this method works the exact same way, but it converts long to string in the
    // first line instead
    String stringNumber = Float.toString(number);
    String[] parts = stringNumber.split("\\.");
    int numOfDigits = parts[0].length();
    return numOfDigits;
  }
  
  /** Method which returns the number of digits in a double. */
  public static int digits(double number) {
    // this method works the exact same way, but it converts double to
    // string in the first line instead
    String stringNumber = Double.toString(number);
    String[] parts = stringNumber.split("\\.");
    int numOfDigits = parts[0].length();
    return numOfDigits;
  }
  
  /** Method which returns the number of digits in a String. */
  public static int digits(String number) {
    // this method works the exact same way, but no conversion is
    // needed as a string argument is passed with this method
    String stringNumber = number;
    String[] parts = stringNumber.split("\\.");
    int numOfDigits = parts[0].length();
    return numOfDigits;
  }
  
  //-----------------------------------------------------------------------------------
  // overloaded Decimals method return the number of digits RIGHT of the decimal point
  //-----------------------------------------------------------------------------------
  
  /** Method which returns the number of decimals in an integer. */
  public static int decimals(int number) {
    // an Integer will never have any decimal values, so it's safe to have the method
    // return "0" no matter the inputted integer
    int numOfDigits = 0;
    return numOfDigits;
  }

  /** Method which returns the number of decimals in a float. */
  public static int decimals(float number) {
    // this method works the exact same way, but it converts long to 
    // string in the first line instead
    String stringNumber = Float.toString(number);
    String[] parts = stringNumber.split("\\.");
    int numOfDigits = parts[1].length();
    return numOfDigits;
  }
  
  /** Method which returns the number of decimals in a double. */
  public static int decimals(double number) {
    // this method works the exact same way, but it converts double to
    // string in the first line instead
    String stringNumber = Double.toString(number);
    String[] parts = stringNumber.split("\\.");
    int numOfDigits = parts[1].length();
    return numOfDigits;
  }

  /** Method which returns the number of decimals in a String. */
  public static int decimals(String number) {
    // this method works the exact same way, but no conversion is needed 
    // as a string argument is passed with this method
    String stringNumber = number;
    String[] parts = stringNumber.split("\\.");
    int numOfDigits = parts[1].length();
    return numOfDigits;
  }
}