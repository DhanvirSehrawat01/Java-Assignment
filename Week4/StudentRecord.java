class Student {
    private String name;
    private String studentId;
    private int mark;

    Student(String name, String studentId, int mark) {
        if (name == null) {
            System.out.println("Invalid name");
        }

        if (studentId == null) {
            System.out.println("Invalid student ID");
        }

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid mark");
        }
        this.name = name;
        this.studentId = studentId;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getMark() {
        return mark;
    }

    public boolean setMark(int newMark) {
        if (newMark >= 0 && newMark <= 100) {
            mark = newMark;
            return true;
        }

        return false;
    }

    public boolean hasPassed() {
        return mark >= 50;
    }

    public String getClassification() {
        if (mark >= 80) {
            return "Distinction";
        } else if (mark >= 70) {
            return "First Class";
        } else if (mark >= 60) {
            return "Second Class";
        } else if (mark >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public String toString() {
        return "Name: " + name +
               ", ID: " + studentId +
               ", Mark: " + mark +
               ", Passed: " + hasPassed() +
               ", Classification: " + getClassification();
    }
}


public class StudentRecord {
    public static void main(String[] args) {

        Student s1 = new Student("Daksh", "S101", 49);
        Student s2 = new Student("Dhruv", "S102", 50);
        Student s3 = new Student("Dhanvir", "S103", 79);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        Student s4 = new Student("Karan", "S104", 80);
        System.out.println(s4);
        System.out.println("Invalid update: " + s1.setMark(120));
        System.out.println(s1);
        System.out.println("Valid update: " + s1.setMark(50));
        System.out.println(s1);
    }
}
