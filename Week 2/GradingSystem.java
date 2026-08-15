import java.util.Scanner;
public class GradingSystem{
    static String classifyMark(int marks) {
        if (marks < 0 || marks > 100) {
            return "Invalid marks Entered";
        } else if (marks >= 80) {
            return "Distinction";
        } else if (marks >= 70) {
            return "Merit";
        } else if (marks >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
        public static void main(String[] args) {
        System.out.println("Please Enter Marks:");
        Scanner input = new Scanner(System.in);
        int marks = input.nextInt();
    System.out.println(classifyMark(marks));
    }
}
