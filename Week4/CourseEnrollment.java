class Course {
    private String courseCode;
    private String title;
    private int capacity;
    private int enrolledCount;

    Course(String courseCode, String title, int capacity) {
        this.courseCode = courseCode;
        this.title = title;

        if (capacity > 0) {
            this.capacity = capacity;
        } else {
           System.out.println("Capacity must be positive");
        }

        enrolledCount = 0;
    }

    boolean enroll() {
        if (enrolledCount < capacity) {
            enrolledCount++;
            return true;
        }

        return false;
    }

    boolean withdraw() {
        if (enrolledCount > 0) {
            enrolledCount--;
            return true;
        }

        return false;
    }

    boolean isFull() {
        return enrolledCount == capacity;
    }

    int getAvailableSeats() {
        return capacity - enrolledCount;
    }

    String getCourseCode() {
        return courseCode;
    }

    String getTitle() {
        return title;
    }

    int getCapacity() {
        return capacity;
    }

    int getEnrolledCount() {
        return enrolledCount;
    }

    public String toString() {
        return "Course [Code=" + courseCode +  ", Title=" + title +  ", Capacity=" + capacity + ", Enrolled=" + enrolledCount +", Available Seats=" + getAvailableSeats() + "]";
    }
}


public class CourseEnrollment {

    public static void main(String[] args) {
        Course course = new Course("CSE101", "Java Programming", 3);

        System.out.println("New course:");
        System.out.println(course);

        System.out.println("\nEnrolling student:");
        System.out.println("Enrollment successful: " + course.enroll());
        System.out.println(course);

        System.out.println("\nEnrolling another student:");
        System.out.println("Enrollment successful: " + course.enroll());
        System.out.println(course);

        System.out.println("\nOne seat remaining:");
        System.out.println("Available seats: " + course.getAvailableSeats());

        System.out.println("Enrollment successful: " + course.enroll());
        System.out.println(course);

        System.out.println("\nIs course full? " + course.isFull());

        System.out.println("Trying to enroll another student:");
        System.out.println("Enrollment successful: " + course.enroll());
        System.out.println(course);

        System.out.println("\nWithdrawing a student:");
        System.out.println("Withdrawal successful: " + course.withdraw());
        System.out.println(course);

        course.withdraw();
        course.withdraw();

        System.out.println("\nCourse after all students withdraw:");
        System.out.println(course);

        System.out.println("Trying to withdraw from empty course:");
        System.out.println("Withdrawal successful: " + course.withdraw());
        System.out.println(course);
    }
}
