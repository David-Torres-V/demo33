package com.example.demo.initialization;

import com.example.demo.binding.Product;
import com.example.demo.binding.User;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@ComponentScan("com.example.demo.initialization")
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DataInitializer(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // Crear usuarios
        User user1 = new User();
        user1.setId(1);
        user1.setName("Luis Perez");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Juan Perez");

        User user3 = new User();
        user3.setId(3);
        user3.setName("Ana Perez");

        List<User> users = Arrays.asList(user1, user2, user3);

        // Guardar usuarios en la base de datos
        userRepository.saveAll(users);

        // Crear productos
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Google Home");
        product1.setDescription("Asistente Google Home");
        product1.setCharacteristics("Asistente de voz Google Home para casa");
        product1.setPrice(260.0);
        product1.setProductKeys("Asistente, IA, Home, parlante");
        product1.setUrl("GoogleHome");
        product1.setCategory("Tecnologia");
        product1.setSubcategory("accesorios");

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Nuevo Echo Dot (4ta Generación, Edición 2020)");
        product2.setDescription("Nuevo Echo Dot (4ta Generación, Edición 2020)");
        product2.setCharacteristics("Nuevo echo dot 4a edicion parlante inteligente Alexa");
        product2.setPrice(70.0);
        product2.setProductKeys("Asistente, IA, Home, parlante");
        product2.setUrl("EchoDot");
        product2.setCategory("Tecnologia");
        product2.setSubcategory("accesorios");

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Echo Pop");
        product3.setDescription("Parlante inteligente y compacto con sonido definido y Alexa | versión internacional");
        product3.setPrice(40.0);
        product3.setProductKeys("Asistente, IA, Home, parlante");
        product3.setUrl("EchoPop");
        product3.setCategory("Tecnologia");
        product3.setSubcategory("parlante");

        List<Product> products = Arrays.asList(product1, product2, product3);

        // Guardar productos en la base de datos
        productRepository.saveAll(products);
    }
}
