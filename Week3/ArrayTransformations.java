import java.util.Scanner;
public class ArrayTransformations 
{
    static void reverseInPlace(int[] values)
     {
        int left = 0;
        int right = values.length - 1;
        while (left < right)
         {
            int temp = values[left];
            values[left] = values[right];
            values[right] = temp;

            left++;
            right--;
        }
    }
    static int[] reversedCopy(int[] values) 
    {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) 
        {
            result[i] = values[values.length - 1 - i];
        }
        return result;
    }
    static int removeValue(int[] values, int target) 
    {
        int newLength = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != target)
             {
                values[newLength] = values[i];
                newLength++;
            }
        }
        return newLength;
    }
    static int[] runningSum(int[] values) 
    {
        int[] result = new int[values.length];
        if (values.length == 0)
        {
            return result;
        }
        result[0] = values[0];
        for (int i = 1; i < values.length; i++) 
        {
            result[i] = result[i - 1] + values[i];
        }
        return result;
    }
    static void printArray(int[] values) 
    {
        for (int i = 0; i < values.length; i++) 
        {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = input.nextInt();
        int[] values = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) 
        {
            values[i] = input.nextInt();
        }
        System.out.println("Original array:");
        printArray(values);
        reverseInPlace(values);
        System.out.println("After reverseInPlace:");
        printArray(values);
        int[] copy = reversedCopy(values);
        System.out.println("Reversed copy:");
        printArray(copy);
        System.out.print("Enter value to remove: ");
        int target = input.nextInt();
        int newLength = removeValue(values, target);
        System.out.println("Array after removeValue:");
        for (int i = 0; i < newLength; i++)
         {
            System.out.print(values[i] + " ");
        }
        System.out.println();
        System.out.println("Logical length: " + newLength);
        System.out.println("Original array length: " + values.length);
        int[] sums = runningSum(values);

        System.out.println("Running sum:");
        for (int i = 0; i < newLength; i++) 
        {
            System.out.print(sums[i] + " ");
        }
        System.out.println();
        input.close();
    }
}
