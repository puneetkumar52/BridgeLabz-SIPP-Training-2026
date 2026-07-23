import java.util.*;
import java.util.stream.*;

// Abstract Person here
abstract class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + email;
    }
}

// Customer extends person here
class Customer extends Person {
    private String city;
    private boolean primeMember;

    public Customer(int id, String name, String email, String city, boolean primeMember) {
        super(id, name, email);
        this.city = city;
        this.primeMember = primeMember;
    }

    public String getCity() { return city; }
    public boolean isPrimeMember() { return primeMember; }

    @Override
    public String toString() {
        return super.toString() + " | City: " + city + " | Prime: " + primeMember;
    }
}

// Seller extends person here
class Seller extends Person {
    private String companyName;
    private double sellerRating;

    public Seller(int id, String name, String email, String companyName, double sellerRating) {
        super(id, name, email);
        this.companyName = companyName;
        this.sellerRating = sellerRating;
    }

    public String getCompanyName() { return companyName; }
    public double getSellerRating() { return sellerRating; }

    @Override
    public String toString() {
        return super.toString() + " | Company: " + companyName + " | Rating: " + sellerRating;
    }
}

// Product class new here 
class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;
    private double rating;
    private boolean inStock;
    private Seller seller;

    public Product(int productId, String productName, String category, double price, double rating, boolean inStock, Seller seller) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.inStock = inStock;
        this.seller = seller;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public boolean isInStock() { return inStock; }
    public Seller getSeller() { return seller; }

    @Override
    public String toString() {
        return productId + " | " + productName + " | " + category + " | Rs." + price +
               " | Rating: " + rating + " | InStock: " + inStock +
               " | Seller: " + seller.getName();
    }
}

// Main method for ShoppingSystem
public class ShoppingSystem {
    public static void main(String[] args) {
        // 3 Sellers info
        Seller s1 = new Seller(1, "Ravi", "ravi@sellers.com", "TechWorld", 4.8);
        Seller s2 = new Seller(2, "Meena", "meena@sellers.com", "FashionHub", 4.2);
        Seller s3 = new Seller(3, "Arjun", "arjun@sellers.com", "HomeMart", 4.9);

        // 4 Customers info
        Customer c1 = new Customer(101, "Alice", "alice@mail.com", "Delhi", true);
        Customer c2 = new Customer(102, "Bob", "bob@mail.com", "Mumbai", false);
        Customer c3 = new Customer(103, "Charlie", "charlie@mail.com", "Delhi", true);
        Customer c4 = new Customer(104, "Diana", "diana@mail.com", "Pune", false);

        // 8 Products info
        List<Product> products = Arrays.asList(
            new Product(201, "Laptop", "Electronics", 55000, 4.7, true, s1),
            new Product(202, "Smartphone", "Electronics", 15000, 4.5, true, s1),
            new Product(203, "Shoes", "Fashion", 1200, 4.2, false, s2),
            new Product(204, "T-Shirt", "Fashion", 800, 4.0, true, s2),
            new Product(205, "Microwave", "HomeAppliance", 7000, 4.6, true, s3),
            new Product(206, "Mixer", "HomeAppliance", 2500, 4.1, false, s3),
            new Product(207, "Book", "Stationery", 500, 4.8, true, s1),
            new Product(208, "Watch", "Fashion", 2000, 4.3, true, s2)
        );

        List<Customer> customers = Arrays.asList(c1, c2, c3, c4);
        List<Seller> sellers = Arrays.asList(s1, s2, s3);

        // Stream Operations 
        System.out.println("\nAll Product Names:");
        products.stream().map(Product::getProductName).forEach(System.out::println);

        System.out.println("\nProducts In Stock:");
        products.stream().filter(Product::isInStock).forEach(System.out::println);

        System.out.println("\nProducts costing > 1000:");
        products.stream().filter(p -> p.getPrice() > 1000).forEach(System.out::println);

        System.out.println("\nPrime Customers:");
        customers.stream().filter(Customer::isPrimeMember).forEach(System.out::println);

        System.out.println("\nSellers with rating > 4.5:");
        sellers.stream().filter(s -> s.getSellerRating() > 4.5).forEach(System.out::println);

        System.out.println("\nProducts sorted by price:");
        products.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);

        System.out.println("\nSellers sorted by rating (desc):");
        sellers.stream().sorted(Comparator.comparing(Seller::getSellerRating).reversed()).forEach(System.out::println);

        System.out.println("\nUnique Product Categories:");
        products.stream().map(Product::getCategory).distinct().forEach(System.out::println);

        System.out.println("\nCount of Products In Stock: " + products.stream().filter(Product::isInStock).count());

        System.out.println("\nCostliest Product: " + products.stream().max(Comparator.comparing(Product::getPrice)).get());
        System.out.println("Cheapest Product: " + products.stream().min(Comparator.comparing(Product::getPrice)).get());

        System.out.println("\nAverage Product Price: " + products.stream().mapToDouble(Product::getPrice).average().getAsDouble());

        System.out.println("\nTotal Value of Products: " + products.stream().map(Product::getPrice).reduce(0.0, Double::sum));

        System.out.println("\nAll products in stock? " + products.stream().allMatch(Product::isInStock));
        System.out.println("Any customer from Delhi? " + customers.stream().anyMatch(c -> c.getCity().equalsIgnoreCase("Delhi")));

        System.out.println("\nFirst Prime Customer: " + customers.stream().filter(Customer::isPrimeMember).findFirst().get());

        System.out.println("\nTop 3 Highest Rated Products:");
        products.stream().sorted(Comparator.comparing(Product::getRating).reversed()).limit(3).forEach(System.out::println);

        System.out.println("\nGroup Products by Category:");
        Map<String, List<Product>> byCategory = products.stream().collect(Collectors.groupingBy(Product::getCategory));
        byCategory.forEach((cat, list) -> System.out.println(cat + " → " + list));

        System.out.println("\nGroup Products by Seller:");
        Map<Seller, List<Product>> bySeller = products.stream().collect(Collectors.groupingBy(Product::getSeller));
        bySeller.forEach((seller, list) -> System.out.println(seller.getName() + " → " + list));

        System.out.println("\nPartition Products (In Stock vs Out of Stock):");
        Map<Boolean, List<Product>> partition = products.stream().collect(Collectors.partitioningBy(Product::isInStock));
        System.out.println(partition);

        System.out.println("\nMap<ProductId, Product>:");
        Map<Integer, Product> productMap = products.stream().collect(Collectors.toMap(Product::getProductId, p -> p));
        productMap.forEach((id, prod) -> System.out.println(id + " → " + prod));

        System.out.println("\nCustomer Names (comma-separated):");
        String names = customers.stream().map(Customer::getName).collect(Collectors.joining(", "));
        System.out.println(names);
    }
}
