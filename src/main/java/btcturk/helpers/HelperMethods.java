package btcturk.helpers;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HelperMethods {

    public static String getRandomDescription() {
        Faker faker = new Faker();

        return faker.lorem().paragraph(1);

    }

    public static String getRandomTitle() {
        Faker faker = new Faker();

        return faker.lorem().sentence(1);

    }

    public static String getRandomUrl() {
        Faker faker = new Faker();

        return "https://" + faker.internet().url() + "/images";

    }

    public static Integer getRandomPrice() {
        Faker faker = new Faker();

        return faker.number().numberBetween(5000, 50000);

    }

    public static Integer getRandomInvalidOrderId() {
        Faker faker = new Faker();

        return faker.number().numberBetween(3, Integer.MAX_VALUE);

    }

    public static Integer getRandomStock() {
        Faker faker = new Faker();

        return faker.number().numberBetween(1, 100);

    }

    public static String getRandomCategory() {
        List<String> categoryList = Arrays.asList("iPad", "smartphones", "TV", "computer", "iPhone", "watch");
        Random random = new Random();
        return categoryList.get(random.nextInt(categoryList.size()));

    }

    public static String getRandomBrand() {
        List<String> brandList = Arrays.asList("AirTag", "Apple TV HD", "Apple TV 4K", "Apple Watch", "iPad Air", "iPad Pro", "iPhone", "Mac Pro", "MacBook Air");
        Random random = new Random();
        return brandList.get(random.nextInt(brandList.size()));

    }


    public static Double getRandomRating() {
        Faker faker = new Faker();

        return faker.number().randomDouble(2, 1, 10);

    }


    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

}
