import java.util.Scanner;

public class LoopPatterns {
    static void patternA(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void patternC(int size) {
        for (int row = 1; row <= size; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = input.nextInt();
        if (size < 1) {
            System.out.println("Invalid size. Size must be at least 1.");
            return;
        }

        System.out.println("\nPattern A:");
        patternA(size);

        System.out.println("\nPattern C:");
        patternC(size);
        input.close();
    }
}