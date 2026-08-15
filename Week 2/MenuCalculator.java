import java.util.Scanner;
public class MenuCalculator {
  static void printMenu() {
        System.out.println("Calculator Menu:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("0. Exit");
    }
    static float calc(int option, float n1, float n2){
          switch (option) {
            case 1:
                return n1+n2;

            case 2:
                return n1-n2;

            case 3:
                return n1*n2;

            case 4:
                return n1/n2;
                default:
                    return 0;
        }
    }
    public static void main(String[]args){
        Scanner input= new Scanner(System.in);
         int option;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            option = input.nextInt();

            if (option < 0 || option > 4) {
                System.out.println("Invalid menu choice.");
                continue;
            }

            if (option == 0) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter first number: ");
            float n1 = input.nextFloat();

            System.out.print("Enter second number: ");
            float n2 = input.nextFloat();

            if (option == 4 && n2 == 0) {
                System.out.println("Error: Cannot divide by zero.");
                continue;
            }

            float result = calc(option, n1, n2);

            System.out.println("Result: " + result);

        } while (option != 0);

        input.close();
    }
    }

