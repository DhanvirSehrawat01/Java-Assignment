class Profile {
    private String name;
    private int age;
    private double heightMetres;
    Profile(String name, int age, double heightMetres) {
        if (name == null) {
            System.out.println("Name cannot be blank");
        }

        if (age < 0) {
            System.out.println("Age cannot be negative");
        }

        if (heightMetres <= 0) {
           System.out.println("Height must be positive");
        }
        this.name = name;
        this.age = age;
        this.heightMetres = heightMetres;
    }
    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getHeightMetres() {
        return heightMetres;
    }

    public String toString() {
        return "Profile [Name=" + name + ", Age=" + age +", Height=" + heightMetres + " metres]";
    }
}

public class TextProfile {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide name, age and height.");
            return;
        }

        String name = args[0];

        int age = Integer.parseInt(args[1]);

        double height = Double.parseDouble(args[2]);

        Profile profile = new Profile(name, age, height);

        System.out.println(profile);

        String ageText = Integer.toString(age);
        String heightText = Double.toString(height);

        System.out.println("Age as String: " + ageText);
        System.out.println("Height as String: " + heightText);
    }
}