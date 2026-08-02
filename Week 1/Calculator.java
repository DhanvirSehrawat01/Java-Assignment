import java.util.Scanner;
public class Calculator {
    public static void main(String[]args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first digit:");
        double n1 = input.nextDouble();
        System.out.println("Enter the second digit:");
        double n2 = input.nextDouble();
        System.out.println("Sum:"+(n1+n2));
        System.out.println("Difference:"+(n1-n2));
        System.out.println("Product:"+(n1*n2));
        System.out.println("Quotient:"+(n1/n2));
        System.out.println("Remainder:"+(n1%n2));
        input.close();
    }

}
