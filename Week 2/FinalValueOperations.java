import java.util.Scanner;

public class FinalValueOperations {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = 0;
        System.out.println("Enter number of operations: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter operation: ");
            String operation = input.next();

            if (operation.contains("+")) {
                x++;
            } else {
                x--;
            }
        }
        System.out.println("The Final value of x is: " + x);
        input.close();
    }
}
