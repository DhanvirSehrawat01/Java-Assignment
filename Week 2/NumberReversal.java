import java.util.Scanner;
public class NumberReversal {
    static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }
        return reversed;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative integer:");
        int number = input.nextInt();
        System.out.println("Reversed number is:" + reverseNumber(number));
        input.close();
    }
}
