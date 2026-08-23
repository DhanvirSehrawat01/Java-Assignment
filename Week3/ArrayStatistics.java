import java.util.Scanner;
public class ArrayStatistics 
{
    static int sum(int[] values) {
        int total = 0;
        for (int i = 0; i < values.length; i++)
             {
            total = total + values[i];
             }
        return total;
    }
    static double average(int[] values) {
        if (values.length == 0) {
            return 0;
        }
        return (double) sum(values) / values.length;
    }
    static int minimum(int[] values) {
        if (values.length == 0) {
            return 0;
        }
        int min = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }
    static int maximum(int[] values) {
        if (values.length == 0) {
            return 0;
        }
        int max = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
    static int countEven(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    static void printSignCounts(int[] values) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                positive++;
            } 
            else if (values[i] < 0) {
                negative++;
            } 
            else {
                zero++;
            }
        }
        System.out.println("Positive count: " + positive);
        System.out.println("Negative count: " + negative);
        System.out.println("Zero count: " + zero);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = input.nextInt();

        int[] values = new int[n];

        if (n == 0) {
            System.out.println("Array is empty");
        } 
        else {

            System.out.println("Enter array elements:");

            for (int i = 0; i < n; i++) {
                values[i] = input.nextInt();
            }

            System.out.println("Sum: " + sum(values));
            System.out.println("Average: " + average(values));
            System.out.println("Minimum: " + minimum(values));
            System.out.println("Maximum: " + maximum(values));
            int even = countEven(values);
            int odd = n - even;
            System.out.println("Even count: " + even);
            System.out.println("Odd count: " + odd);
            printSignCounts(values);
        }
        input.close();
    }
}