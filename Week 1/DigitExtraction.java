import java.util.Scanner;
public class DigitExtraction {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a three digit positive integer:");
        int number = input.nextInt();
         
        int hundreds = number/100;
        int tens = (number%100)/10;
        int ones = number%10;
        System.out.println("Hundreds:"+hundreds);
        System.out.println("Tens:"+tens);
        System.out.println("Units:"+ones);
        input.close();
    }

}
