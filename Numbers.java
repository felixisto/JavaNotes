import java.util.ArrayList;
import java.util.Arrays;

public class Numbers
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA Number samples\n* * * *");
    	System.out.println("Java has int, double, float AND byte for number values. There is no native support for unsigned integers.");
    	
        // Arithmetic
        System.out.println("");
        int a = 1;
        int b = 2;
        System.out.println("Testing int a=" + String.valueOf(a) + " int b=" + String.valueOf(b) + "...");
        System.out.println("a + b = " + String.valueOf(a + b));
        System.out.println("a * b = " + String.valueOf(a * b));
        System.out.println("a / b = " + String.valueOf(a / b));
        System.out.println("a % b = " + String.valueOf(a % b));
        System.out.println("Math.pow(a, 2) = " + String.valueOf(Math.pow(a, 2)));
        System.out.println("Math.pow(b, 2) = " + String.valueOf(Math.pow(b, 2)));
        System.out.println("Math.sqrt(a) = " + String.valueOf(Math.sqrt(a)));
        System.out.println("Math.sqrt(b) = " + String.valueOf(Math.sqrt(b)));
        
        // Conditions
        System.out.println("");
        double x = 100;
        double y = 20.56;
        System.out.println("Testing double x=" + String.valueOf(x) + " double y=" + String.valueOf(y) + "...");
        System.out.println("x is NaN " + String.valueOf(Double.isNaN(x)));
        System.out.println("y is INFINITY " + String.valueOf(Double.isInfinite(y)));
        
        // Conversion
        System.out.println("");
        String aNumberS = "100";
        int myInt = 100;
        double myDouble = 100.5;
        System.out.println("String '100' to int " + String.valueOf(Integer.parseInt(aNumberS)));
        System.out.println("String '100' to double " + String.valueOf(Double.parseDouble(aNumberS)));
        System.out.println("int 100 to double " + (double)myInt);
        System.out.println("double 100.5 to int " + (int)myDouble);
        System.out.println("Math.round double 100.1 = " + Math.round(100.1));
        System.out.println("Math.round double 100.5 = " + Math.round(myDouble));
        System.out.println("Math.round double 100.9 = " + Math.round(100.9));
        
        // Overflow
        System.out.println("");
        System.out.print("If an integer overflows, it goes back to the minimum value and continues from there.");
        System.out.println(" If it underflows, it goes back to the maximum value and continues from there.");
        
        int overflowA = Integer.MAX_VALUE;
        overflowA += 1;
        System.out.println("Integer.MAX_VALUE (" + String.valueOf(Integer.MAX_VALUE) + ") + 1 = " + String.valueOf(overflowA));
        overflowA = Integer.MIN_VALUE;
        overflowA -= 1;
        System.out.println("Integer.MIN_VALUE (" + String.valueOf(Integer.MIN_VALUE) + ") - 1 = " + String.valueOf(overflowA));
        
        overflowA = Integer.MAX_VALUE;
        System.out.println("Will addition overflow (Integer.MAX_VALUE + 1)? = " + String.valueOf(Numbers.willAdditionOverflow(overflowA, 1)));
        System.out.println("Will addition overflow ((Integer.MAX_VALUE-1) + 1)? = " + String.valueOf(Numbers.willAdditionOverflow(overflowA-1, 1)));
    }
    
    public static boolean willAdditionOverflow(int left, int right) 
    {
       try {
            Math.addExact(left, right);
            return false;
       } 
       catch (ArithmeticException e) 
       {
           return true;
       }
    }
    
    public static boolean willSubtractionOverflow(int left, int right)
    {
        try {
            Math.subtractExact(left, right);
            return false;
        } 
        catch (ArithmeticException e) 
        {
            return true;
        }
    }
}
