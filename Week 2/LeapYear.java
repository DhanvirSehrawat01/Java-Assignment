import java.util.Scanner;
public class LeapYear {
    static boolean isLeapYear(int year){
        if(year%4==0){
            return true;
        }
        else{
            return false;
        }
    }
   public static void main(String[]args){
    System.out.println("Enter Year:");
    Scanner input = new Scanner(System.in);
    int year = input.nextInt();
    System.out.println(isLeapYear(year));
   }
}
