public class CampusManagementApp {

    public static void main(String[] args) {

        Student s1 = new Student(
            "Ravinder",
            20,
            new int[]{78, 85, 90}
        );

        Student s2 = new Student(
            "Balwinder",
            21,
            new int[]{88, 92, 95}
        );

        Student s3 = new Student(
            "Sukhwinder",
            19,
            new int[]{70, 82, 76}
        );

        Instructor i1 = new Instructor(
            "Dr. Sharma",
            45,
            "Java Programming"
        );

        Instructor i2 = new Instructor(
            "Dr. Mehta",
            40,
            "Database Systems"
        );

        CampusRegistry registry = new CampusRegistry(10);

        registry.addPerson(s1);
        registry.addPerson(s2);
        registry.addPerson(s3);
        registry.addPerson(i1);
        registry.addPerson(i2);

        System.out.println("CAMPUS REGISTRY:");
        System.out.println();

        registry.displayPeople();

        System.out.println();

        System.out.println("SEARCH RESULT:");

        Person found = registry.searchByName("Balwinder");

        if (found != null) {
            System.out.println("Person Found:");
            System.out.println(found);
        } else {
            System.out.println("Person not found");
        }

        System.out.println();

        System.out.println("HIGHEST STUDENT RESULT:");

        Student highest = registry.findHighestStudent();

        if (highest != null) {
            System.out.println("Student with highest result:");
            System.out.println(highest);
            System.out.println(
                "Average Marks: " + highest.calculateAverage()
            );
        } else {
            System.out.println("No students found");
        }

        System.out.println();

        System.out.println("STUDENT DETAILS:");

        Person person = registry.searchByName("Ravinder");

        if (person instanceof Student) {
            Student student = (Student) person;

            System.out.println(
                "Student performance average: "
                + student.calculateAverage()
            );
        }
    }
}


abstract class Person {

    private String name;
    private int age;

    public Person(String name, int age) {

        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty" );
        }

        if (age <= 0) {
             System.out.println( "Age must be positive");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return "Name: " + name +
               ", Age: " + age +
               ", Role: " + getRoleDescription();
    }
}


class Student extends Person {

    private int[] marks;

    public Student(String name, int age, int[] marks) {

        super(name, age);

        if (marks == null || marks.length == 0) {
          System.out.println("Marks array cannot be empty.");
        }

        this.marks = marks;
    }

    public int[] getMarks() {
        return marks;
    }

    public double calculateAverage() {

        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    @Override
    public String getRoleDescription() {
        return "Student";
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Average Marks: " + calculateAverage();
    }
}


class Instructor extends Person {

    private String subject;

    public Instructor(String name, int age, String subject) {

        super(name, age);

        if (subject == null || subject.isEmpty()) {
          System.out.println( "Subject cannot be empty.");
        }

        this.subject = subject;
    }

    @Override
    public String getRoleDescription() {
        return "Instructor";
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Subject: " + subject;
    }
}


class CampusRegistry {

    private Person[] people;
    private int size;

    public CampusRegistry(int capacity) {

        if (capacity <= 0) {
           System.out.println( "Capacity must be positive.");
        }

        people = new Person[capacity];
        size = 0;
    }

    public boolean addPerson(Person person) {

        if (person == null) {
            return false;
        }

        if (size >= people.length) {
            return false;
        }

        people[size] = person;
        size++;

        return true;
    }
    public Person searchByName(String name) {

        for (int i = 0; i < size; i++) {

            if (people[i].getName().equalsIgnoreCase(name)) {
                return people[i];
            }
        }

        return null;
    }
    public Student findHighestStudent() {

        Student highest = null;

        for (int i = 0; i < size; i++) {

            if (people[i] instanceof Student) {

                Student student = (Student) people[i];

                if (highest == null ||
                    student.calculateAverage()
                    > highest.calculateAverage()) {

                    highest = student;
                }
            }
        }
        return highest;
    }
    public void displayPeople() {

        for (int i = 0; i < size; i++) {

            System.out.println(people[i]);
        }
    }
}
