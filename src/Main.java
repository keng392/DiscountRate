package Exam;

interface DiscountRate {
    double getServiceDiscountRate(String type);
    double getProductDiscountRate(String type);
}

class Customer implements DiscountRate {
    String type;

    Customer(String type) {
        this.type = type;
    }

    @Override
    public double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }

    @Override
    public double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }
}

class Sale {
    double serviceDiscountRate;
    double productDiscountRate;

    Sale(Customer customer) {
        this.serviceDiscountRate = customer.getServiceDiscountRate(customer.type);
        this.productDiscountRate = customer.getProductDiscountRate(customer.type);
    }
}

public class Main {
    public static void main(String[] args) {
        Customer premiumCustomer = new Customer("Premium");
        Sale premiumSale = new Sale(premiumCustomer);
        System.out.println("Premium Customer Service Discount Rate: " + premiumSale.serviceDiscountRate);
        System.out.println("Premium Customer Product Discount Rate: " + premiumSale.productDiscountRate);

        Customer normalCustomer = new Customer("Normal");
        Sale normalSale = new Sale(normalCustomer);
        System.out.println("Normal Customer Service Discount Rate: " + normalSale.serviceDiscountRate);
        System.out.println("Normal Customer Product Discount Rate: " + normalSale.productDiscountRate);
    }
}