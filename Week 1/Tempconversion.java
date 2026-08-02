//fahrenheit = celsius * 9.0 / 5.0 + 32.0
import java.util.Scanner;
public class Tempconversion {
    public static void main(String[]args) throws Exception{
     Scanner input = new Scanner(System.in);
     System.out.println("Enter the temperature in Celsius:");
     double Temp = input.nextDouble();
     System.out.println("Fahrenheit conversion:"+ ((Temp*9.0/5.0)+32));
     input.close();
    }

}
