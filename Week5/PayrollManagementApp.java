public class PayrollManagementApp {
    public static void main(String[] args) {
        SalariedEmployee e1 = new SalariedEmployee(
            "E101", "Dhanvir", 50000
        );
        SalariedEmployee e2 = new SalariedEmployee(
            "E102", "Dhruv", 65000
        );
        HourlyEmployee e3 = new HourlyEmployee(
            "E103", "Pratyush", 160, 300
        );
        HourlyEmployee e4 = new HourlyEmployee(
            "E104", "Abhinav", 120, 400
        );
        Invoice invoice = new Invoice(
            "INV001", "Computer Equipment", 25000
        );

        PayrollProcessor processor = new PayrollProcessor(10);
        processor.addPayment(e1);
        processor.addPayment(e2);
        processor.addPayment(e3);
        processor.addPayment(e4);
        processor.addPayment(invoice);

        System.out.println("PAYROLL MANAGEMENT:");
        System.out.println();

        processor.displayPayments();

        System.out.println();

        System.out.println("Total Payment: "
                + processor.calculateTotalPayment());

        System.out.println();

        System.out.println("LARGEST PAYMENT:");

        Payable largest = processor.findLargestPayment();

        if (largest != null) {
            System.out.println(largest);
        }

        System.out.println();

        System.out.println("===== PAYMENT COUNT =====");

        System.out.println(
            "Employee Payments: "
            + processor.countEmployees()
        );

        System.out.println(
            "Non-Employee Payments: "
            + processor.countNonEmployees()
        );

        System.out.println();

        System.out.println("===== EMPLOYEE DETAILS =====");

        processor.displayEmployeeDetails();
    }
}


interface Payable {

    double calculatePayment();
}

abstract class Employee implements Payable {

    private String employeeId;
    private String name;

    public Employee(String employeeId, String name) {

        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException(
                "Employee ID cannot be empty"
            );
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                "Name cannot be empty"
            );
        }

        this.employeeId = employeeId;
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public abstract String getEmployeeType();

    @Override
    public String toString() {
        return "Employee ID: " + employeeId
                + ", Name: " + name
                + ", Type: " + getEmployeeType()
                + ", Payment: " + calculatePayment();
    }
}


class SalariedEmployee extends Employee {

    private double monthlySalary;

    public SalariedEmployee(
        String employeeId,
        String name,
        double monthlySalary
    ) {

        super(employeeId, name);

        if (monthlySalary <= 0) {
            throw new IllegalArgumentException(
                "Salary must be positive"
            );
        }

        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePayment() {
        return monthlySalary;
    }

    @Override
    public String getEmployeeType() {
        return "Salaried Employee";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Monthly Salary: " + monthlySalary;
    }
}


class HourlyEmployee extends Employee {

    private double hoursWorked;
    private double hourlyRate;

    public HourlyEmployee(
        String employeeId,
        String name,
        double hoursWorked,
        double hourlyRate
    ) {

        super(employeeId, name);

        if (hoursWorked <= 0 || hourlyRate <= 0) {
            throw new IllegalArgumentException(
                "Hours and hourly rate must be positive"
            );
        }

        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePayment() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getEmployeeType() {
        return "Hourly Employee";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Hours Worked: " + hoursWorked
                + ", Hourly Rate: " + hourlyRate;
    }
}


class Invoice implements Payable {

    private String invoiceId;
    private String description;
    private double amount;

    public Invoice(
        String invoiceId,
        String description,
        double amount
    ) {

        if (invoiceId == null || invoiceId.isEmpty()) {
            throw new IllegalArgumentException(
                "Invoice ID cannot be empty."
            );
        }

        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException(
                "Description cannot be empty"
            );
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be positive"
            );
        }

        this.invoiceId = invoiceId;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public double calculatePayment() {
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice ID: " + invoiceId
                + ", Description: " + description
                + ", Payment: " + calculatePayment();
    }
}


class PayrollProcessor {

    private Payable[] payments;
    private int size;

    public PayrollProcessor(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Capacity must be positive"
            );
        }

        payments = new Payable[capacity];
        size = 0;
    }

    public boolean addPayment(Payable payment) {

        if (payment == null) {
            return false;
        }

        if (size >= payments.length) {
            return false;
        }

        payments[size] = payment;
        size++;

        return true;
    }

    public double calculateTotalPayment() {

        double total = 0;

        for (int i = 0; i < size; i++) {
            total += payments[i].calculatePayment();
        }

        return total;
    }

    public void displayPayments() {

        for (int i = 0; i < size; i++) {
            System.out.println(payments[i]);
        }
    }

    public Payable findLargestPayment() {

        if (size == 0) {
            return null;
        }

        Payable largest = payments[0];

        for (int i = 1; i < size; i++) {

            if (payments[i].calculatePayment()
                    > largest.calculatePayment()) {

                largest = payments[i];
            }
        }

        return largest;
    }

    public int countEmployees() {

        int count = 0;

        for (int i = 0; i < size; i++) {

            if (payments[i] instanceof Employee) {
                count++;
            }
        }

        return count;
    }

    public int countNonEmployees() {

        int count = 0;

        for (int i = 0; i < size; i++) {

            if (!(payments[i] instanceof Employee)) {
                count++;
            }
        }

        return count;
    }

    public void displayEmployeeDetails() {

        for (int i = 0; i < size; i++) {

            if (payments[i] instanceof Employee) {

                Employee employee = (Employee) payments[i];

                System.out.println(
                    "ID: " + employee.getEmployeeId()
                    + ", Name: " + employee.getName()
                    + ", Type: " + employee.getEmployeeType()
                );
            }
        }
    }
}
