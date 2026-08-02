//simpleInterest = principal * rate * time / 100
   // finalAmount = principal + simpleInterest
    import java.util.Scanner;

public class Simpleinterest {
    public static void main(String[]args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Principal Amount:");
        double Principal = input.nextDouble();
        System.out.println("Enter the Annual Interest Rate:");
        double Rate = input.nextDouble();
        System.out.println("Enter time:");
        double Time = input.nextDouble();
        System.out.println("Simple Interest:"+(Principal*Rate*Time)/100);
        System.out.println("Final Amount:"+(Principal+((Principal*Rate*Time)/100)));
        input.close();
    }

}
