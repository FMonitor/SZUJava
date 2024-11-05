package LAB3;

import java.util.TreeMap;

public class D_CountPrice {
    public static void main(String[] args) {
        TreeMap<String, Double> priceList = new TreeMap<String, Double>();
        priceList.put("苹果", 55.4);
        priceList.put("香蕉", 34.6);
        priceList.put("橙子", 47.5);
        priceList.put("葡萄", 62.5);

        double sum = 0;
        for (String key : priceList.keySet()) {
            sum += priceList.get(key);
        }
        System.out.println("总价：" + sum);
    }
}