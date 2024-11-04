package LAB3;

import java.util.Map;
import java.util.TreeMap;

class Laptop implements Comparable<Laptop> {
    private String model;
    private double price;

    public Laptop(String model, double price) {
        this.model = model;
        this.price = price;
    }
    public String getModel() {
        return model;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public int compareTo(Laptop other) {
        return Double.compare(this.price, other.price);
    }
    @Override
    public String toString() {
        return "Model: " + model + ", Price: " + price;
    }
}

public class B_CompareComputer {
    public static void main(String[] args) {
        TreeMap<Laptop, String> laptops = new TreeMap<>();
        laptops.put(new Laptop("ModelA", 1000.0), "ModelA");
        laptops.put(new Laptop("ModelB", 800.0), "ModelB");
        laptops.put(new Laptop("ModelC", 600.0), "ModelC");
        laptops.put(new Laptop("ModelD", 1200.0), "ModelD");
        laptops.put(new Laptop("ModelE", 1500.0), "ModelE");
        laptops.put(new Laptop("ModelF", 2000.0), "ModelF");
        laptops.put(new Laptop("ModelG", 1800.0), "ModelG");
        laptops.put(new Laptop("ModelH", 900.0), "ModelH");
        laptops.put(new Laptop("ModelI", 1100.0), "ModelI");
        laptops.put(new Laptop("ModelJ", 1300.0), "ModelJ");

        System.out.println("Laptops sorted by price:");
        for (Map.Entry<Laptop, String> entry : laptops.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}

// package LAB3;

// import java.util.Map;
// import java.util.TreeMap;
// import java.util.Comparator;

// class Laptop {
//     private String model;
//     private double price;

//     public Laptop(String model, double price) {
//         this.model = model;
//         this.price = price;
//     }

//     public String getModel() {
//         return model;
//     }

//     public double getPrice() {
//         return price;
//     }

//     @Override
//     public String toString() {
//         return "Model: " + model + ", Price: " + price;
//     }
// }

// class LaptopPriceComparator implements Comparator<Laptop> {
//     @Override
//     public int compare(Laptop l1, Laptop l2) {
//         return Double.compare(l1.getPrice(), l2.getPrice());
//     }
// }

// public class B_CompareComputer {
//     public static void main(String[] args) {
//         TreeMap<Laptop, String> laptops = new TreeMap<>(new LaptopPriceComparator());
//         laptops.put(new Laptop("ModelA", 1000.0), "ModelA");
//         laptops.put(new Laptop("ModelB", 800.0), "ModelB");
//         laptops.put(new Laptop("ModelC", 600.0), "ModelC");
//         laptops.put(new Laptop("ModelD", 1200.0), "ModelD");
//         laptops.put(new Laptop("ModelE", 1500.0), "ModelE");
//         laptops.put(new Laptop("ModelF", 2000.0), "ModelF");
//         laptops.put(new Laptop("ModelG", 1800.0), "ModelG");
//         laptops.put(new Laptop("ModelH", 900.0), "ModelH");
//         laptops.put(new Laptop("ModelI", 1100.0), "ModelI");
//         laptops.put(new Laptop("ModelJ", 1300.0), "ModelJ");

//         System.out.println("Laptops sorted by price:");
//         for (Map.Entry<Laptop, String> entry : laptops.entrySet()) {
//             System.out.println(entry.getKey());
//         }
//     }
// }