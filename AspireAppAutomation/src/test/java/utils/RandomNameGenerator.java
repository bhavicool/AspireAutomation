package utils;

import java.util.Random;

public class RandomNameGenerator {

    public String generateRandomProductName() {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        String productName="BhaveshAspire"+String.valueOf(rand_int1);
        return productName;
    }
}
