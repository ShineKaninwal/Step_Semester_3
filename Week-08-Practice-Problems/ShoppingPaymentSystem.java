import java.util.*;

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment.");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment.");
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Processing bank transfer.");
        return true;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    Product product;
    int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getSubtotal() {
        return product.price * quantity;
    }
}

class ShoppingCustomer {
    String name;

    ShoppingCustomer(String name) {
        this.name = name;
    }
}

class Order {
    private String orderId;
    private ShoppingCustomer customer;
    private List<OrderItem> items = new ArrayList<>();
    private String status = "Pending";

    Order(String orderId, ShoppingCustomer customer) {
        this.orderId = orderId;
        this.customer = customer;
        System.out.println("Order created for " + customer.name + ".");
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > 0) {
            items.add(new OrderItem(product, quantity));
        }
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void pay(PaymentMethod method, String methodName) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        if (status.equals("Paid")) {
            System.out.println("Order is already paid.");
            return;
        }

        System.out.println("Payment initiated via " + methodName +
                " for Order " + orderId + ".");

        // Mark the order Paid only if the transaction succeeds.
        if (method.processPayment(getTotal())) {
            status = "Paid";
            System.out.println("Payment for Order " + orderId + " successful.");
        } else {
            System.out.println("Payment for Order " + orderId + " failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class ShoppingPaymentSystem {
    public static void main(String[] args) {
        ShoppingCustomer x = new ShoppingCustomer("ShoppingCustomer X");
        Order orderX = new Order("X", x);
        orderX.addProduct(new Product("Product A", 100), 2);
        orderX.addProduct(new Product("Product B", 200), 1);
        orderX.pay(new CreditCardPayment(), "Credit Card");

        ShoppingCustomer y = new ShoppingCustomer("ShoppingCustomer Y");
        Order orderY = new Order("Y", y);
        orderY.pay(new CreditCardPayment(), "Credit Card");

        ShoppingCustomer z = new ShoppingCustomer("ShoppingCustomer Z");
        Order orderZ = new Order("Z", z);
        orderZ.addProduct(new Product("Product C", 300), 1);
        orderZ.pay(new PayPalPayment(), "PayPal");
    }
}

