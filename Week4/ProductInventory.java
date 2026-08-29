class Product {
    private String code;
    private String name;
    private double unitPrice;
    private int quantity;

    private static int productCount = 0;

    Product(String code, String name, double unitPrice) {
        this(code, name, unitPrice, 0);
    }

    Product(String code, String name, double unitPrice, int quantity) {

        if (unitPrice <= 0) {
            System.out.println("Price must be positive");
        }

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative");
        }

        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;

        productCount++;
    }

    void restock(int amount) {
        if (amount > 0) {
            quantity = quantity + amount;
        }
    }

    boolean sell(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity = quantity - amount;
            return true;
        }

        return false;
    }

    double getInventoryValue() {
        return unitPrice * quantity;
    }

    static int getProductCount() {
        return productCount;
    }

    String getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    double getUnitPrice() {
        return unitPrice;
    }

    int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Product [Code=" + code + ", Name=" + name +", Price=" + unitPrice + ", Quantity=" + quantity + ", Inventory Value=" + getInventoryValue() + "]";
    }
}


public class ProductInventory {

    public static void main(String[] args) {

        Product p1 = new Product("P101", "Laptop", 50000);
        Product p2 = new Product("P102", "Mouse", 800, 10);
        Product p3 = new Product("P103", "Keyboard", 1500, 5);

        System.out.println("Products:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\nRestocking Laptop:");
        p1.restock(2);
        System.out.println(p1);

        System.out.println("\nSelling Mouse:");
        System.out.println("Sale successful: " + p2.sell(3));
        System.out.println(p2);

        System.out.println("\nTrying to sell more Mouse:");
        System.out.println("Sale successful: " + p2.sell(20));
        System.out.println(p2);
        System.out.println("\nIndependent quantities:");
        System.out.println("Laptop quantity: " + p1.getQuantity());
        System.out.println("Mouse quantity: " + p2.getQuantity());
        System.out.println("Keyboard quantity: " + p3.getQuantity());
        System.out.println("\nTotal products created: "
                + Product.getProductCount());
    }
}
