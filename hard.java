import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class hard {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1000));
        products.add(new Product("Smartphone", "Electronics", 800));
        products.add(new Product("Headphones", "Electronics", 200));
        products.add(new Product("Sofa", "Furniture", 1500));
        products.add(new Product("Dining Table", "Furniture", 1200));
        products.add(new Product("Chair", "Furniture", 250));
        products.add(new Product("T-shirt", "Clothing", 50));
        products.add(new Product("Jeans", "Clothing", 80));
        products.add(new Product("Jacket", "Clothing", 120));

        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        Map<String, Product> mostExpensiveByCategory = products.stream()
            .collect(Collectors.toMap(Product::getCategory,p -> p,(p1, p2) ->
p1.getPrice() > p2.getPrice() ? p1 : p2 ));

        double averagePrice = products.stream().mapToDouble(Product::getPrice)
            .average().orElse(0.0);

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> 
            System.out.println(category + ": " + productList));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product));

        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
