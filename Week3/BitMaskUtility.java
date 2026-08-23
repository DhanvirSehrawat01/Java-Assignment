import java.util.Scanner;
public class BitMaskUtility 
{
    static boolean isBitSet(int number, int position) 
    {
        int mask = 1 << position;
        return (number & mask) != 0;
    }
    static int setBit(int number, int position) 
    {
        int mask = 1 << position;
        return number | mask;
    }
    static int clearBit(int number, int position)
     {
        int mask = 1 << position;
        return number & ~mask;
    }
    static int toggleBit(int number, int position) 
    {
        int mask = 1 << position;
        return number ^ mask;
    }
    static String toBinary32(int number) 
    {
        String result = "";
        for (int i = 31; i >= 0; i--) 
        {
            if (isBitSet(number, i)) 
            {
                result = result + "1";
            } else 
            {
                result = result + "0";
            }
        }
        return result;
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        System.out.println("\nChoose an operation:");
        System.out.println("1. Check bit");
        System.out.println("2. Set bit");
        System.out.println("3. Clear bit");
        System.out.println("4. Toggle bit");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        if (choice == 5) 
        {
            System.out.println("Program ended.");
            input.close();
            return;
        }
        System.out.print("Enter bit position (0-31): ");
        int position = input.nextInt();
        if (position < 0 || position > 31) 
        {
            System.out.println("Invalid bit position.");
            System.out.println("Bit position must be between 0 and 31.");

        } else
        {

            System.out.println("Before:");
            System.out.println("Decimal: " + number);
            System.out.println("Binary : " + toBinary32(number));

            if (choice == 1) 
            {
                boolean result = isBitSet(number, position);
                System.out.println("\nBit at position " + position + ": " + result);
            } else if (choice == 2)
             {
                int result = setBit(number, position);
                System.out.println("After setting bit:");
                System.out.println("Decimal: " + result);
                System.out.println("Binary : " + toBinary32(result));
            } else if (choice == 3) 
            {
                int result = clearBit(number, position);
                System.out.println("After clearing bit:");
                System.out.println("Decimal: " + result);
                System.out.println("Binary: " + toBinary32(result));
            } else if (choice == 4) {
                int result = toggleBit(number, position);
                System.out.println("\nAfter toggling bit:");
                System.out.println("Decimal: " + result);
                System.out.println("Binary : " + toBinary32(result));
            } else 
            {
                System.out.println("Invalid choice");
            }
        }
        input.close();
    }
}
