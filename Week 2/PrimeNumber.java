import java.util.Scanner;
public class PrimeNumber {

    static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }
        for (int divisor = 2; divisor * divisor <= number; divisor++) {

            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int number = input.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is prime");
        } else {
            System.out.println(number + "not  prime");
        }
        input.close();
    }
}