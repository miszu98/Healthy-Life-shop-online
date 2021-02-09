package com.simpleshop.Config;

import com.simpleshop.Models.Product;
import com.simpleshop.Models.User;
import com.simpleshop.Services.ProductService;
import com.simpleshop.Services.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataConfig {

    private UserService userService;
    private ProductService productService;

    public DataConfig(UserService userService, ProductService productService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.productService = productService;

        // Users
        var user = new User();
        user.setUsername("miszu98");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRole("ROLE_ADMIN");
        user.setEmail("user98@wp.pl");
        user.setPhoneNumber("353543534");
        user.setCode("123456");
        userService.addUser(user);

        var user1 = new User();
        user1.setUsername("user");
        user1.setPassword(passwordEncoder.encode("123"));
        user1.setRole("ROLE_USER");
        user1.setEmail("user@onet.pl");
        user1.setPhoneNumber("643234976");
        user1.setCode("123456");
        userService.addUser(user1);

        // Products

        // Fruits

        var apple = new Product();
        apple.setName("Apples");
        apple.setImg("https://ocdn.eu/pulscms-transforms/1/0Xvk9kuTURBXy83YjQ2OTU0MC0zYWM2LTQwMTUtOTUxNy1jYWJmMDJiMzkzOGQuanBlZ5GVAs0DBwDDw4GhMAE");
        apple.setPricePerKg(2.50);
        apple.setPricePerOne(0.15);
        apple.setQuantity(99);
        apple.setDescription("description");
        apple.setCategory("fresh fruits");
        productService.addProduct(apple);

        var orange = new Product();
        orange.setName("Oranges");
        orange.setImg("https://www.rd.com/wp-content/uploads/2017/12/01_oranges_Finally%E2%80%94Here%E2%80%99s-Which-%E2%80%9COrange%E2%80%9D-Came-First-the-Color-or-the-Fruit_691064353_Lucky-Business.jpg");
        orange.setPricePerKg(3.70);
        orange.setPricePerOne(0.5);
        orange.setQuantity(50);
        orange.setDescription("description");
        orange.setCategory("fresh fruits");
        productService.addProduct(orange);

        var pear = new Product();
        pear.setName("Pears");
        pear.setImg("https://i0.wp.com/cdn-prod.medicalnewstoday.com/content/images/articles/285/285430/two-pears-on-a-table.jpg?w=1155&h=1734");
        pear.setPricePerKg(3.20);
        pear.setPricePerOne(0.30);
        pear.setQuantity(30);
        pear.setDescription("description");
        pear.setCategory("fresh fruits");
        productService.addProduct(pear);

        var banana = new Product();
        banana.setName("Bananas");
        banana.setImg("https://cdn.galleries.smcloud.net/t/galleries/gf-4Mo5-uPSk-WnPj_banany-wlasciwosci-i-wartosci-odzywcze-jakie-witaminy-maja-banany-1920x1080-nocrop.jpg");
        banana.setPricePerKg(2.50);
        banana.setPricePerOne(0.15);
        banana.setQuantity(99);
        banana.setDescription("description");
        banana.setCategory("fresh fruits");
        productService.addProduct(banana);

        var grape = new Product();
        grape.setName("Grapes");
        grape.setImg("https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/323266_1100-1100x628.jpg");
        grape.setPricePerKg(3.70);
        grape.setPricePerOne(0.5);
        grape.setQuantity(50);
        grape.setDescription("description");
        grape.setCategory("fresh fruits");
        productService.addProduct(grape);

        var grenade = new Product();
        grenade.setName("Grenades");
//        grenade.setImg("https://alltop10.org/wp-content/uploads/2018/01/aminokislotyi.jpg");
        grenade.setImg("https://www.grenadetrading.it/images/melograno.jpg");
        grenade.setPricePerKg(3.20);
        grenade.setPricePerOne(0.30);
        grenade.setQuantity(30);
        grenade.setDescription("description");
        grenade.setCategory("fresh fruits");
        productService.addProduct(grenade);

        //Vegetables

        var tomato = new Product();
        tomato.setName("Tomatoes");
        tomato.setImg("https://img.republicworld.com/republic-prod/stories/promolarge/xxhdpi/bhph7vhdvxwxujiw_1589955310.jpeg?tr=w-1242,h-710,f-jpeg");
        tomato.setPricePerKg(2.90);
        tomato.setPricePerOne(0.15);
        tomato.setQuantity(23);
        tomato.setDescription("description.");
        tomato.setCategory("fresh vegetables");
        productService.addProduct(tomato);

        var carrot = new Product();
        carrot.setName("Carrots");
        carrot.setImg("https://www.almanac.com/sites/default/files/image_nodes/carrots-table_popidar-ss.jpg");
        carrot.setPricePerKg(2.90);
        carrot.setPricePerOne(0.15);
        carrot.setQuantity(23);
        carrot.setDescription("description");
        carrot.setCategory("fresh vegetables");
        productService.addProduct(carrot);

        var broccoli = new Product();
        broccoli.setName("Broccoli");
        broccoli.setImg("https://snaped.fns.usda.gov/sites/default/files/styles/crop_ratio_7_5/public/seasonal-produce/2018-05/broccoli.jpg?h=65b39431&itok=xglOu8vA");
        broccoli.setPricePerKg(2.90);
        broccoli.setPricePerOne(0.15);
        broccoli.setQuantity(23);
        broccoli.setDescription("description");
        broccoli.setCategory("fresh vegetables");
        productService.addProduct(broccoli);

        var cauliflower = new Product();
        cauliflower.setName("Cauliflower");
        cauliflower.setImg("https://snaped.fns.usda.gov/sites/default/files/styles/crop_ratio_7_5/public/seasonal-produce/2018-05/cauliflower.jpg?h=c8b8df1c&itok=XVi8_6bg");
        cauliflower.setPricePerKg(2.90);
        cauliflower.setPricePerOne(0.15);
        cauliflower.setQuantity(23);
        cauliflower.setDescription("description");
        cauliflower.setCategory("fresh vegetables");
        productService.addProduct(cauliflower );

        var radish = new Product();
        radish.setName("Radish");
        radish.setImg("https://www.thespruceeats.com/thmb/v4rXBdHk-ncJwtyC9zXXYKFAKcc=/2121x1414/filters:fill(auto,1)/GettyImages-994593838-de50e6d7db9a4b328fbfd17f3371dbee.jpg");
        radish.setPricePerKg(2.90);
        radish.setPricePerOne(0.15);
        radish.setQuantity(23);
        radish.setDescription("description");
        radish.setCategory("fresh vegetables");
        productService.addProduct(radish);

        var cucumber = new Product();
        cucumber.setName("Cucumber");
        cucumber.setImg("https://snaped.fns.usda.gov/sites/default/files/styles/crop_ratio_7_5/public/seasonal-produce/2018-05/cucumbers2.jpg?itok=YISLeW4e");
        cucumber.setPricePerKg(2.90);
        cucumber.setPricePerOne(0.15);
        cucumber.setQuantity(23);
        cucumber.setDescription("description");
        cucumber.setCategory("fresh vegetables");
        productService.addProduct(cucumber);


    }
}
