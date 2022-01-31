package utils;

import java.util.Random;

public class RandomNameGenerator {

    String productName;

    public void setProductName(String productName) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        productName=productName+String.valueOf(rand_int1);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
