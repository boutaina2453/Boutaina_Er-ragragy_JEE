package ma.enset.student;

import ma.enset.student.entities.Product;
import ma.enset.student.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

    // Injection de ProductRepository dans l'instance de la classe
    @Autowired
    private ProductRepository productRepository;

    // La méthode main reste inchangée, Spring gère l'application
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        productRepository.save(new Product(null, "computer", 6000.0, 3));
        productRepository.save(new Product(null, "Printer", 1200.0, 4));
        productRepository.save(new Product(null, "Smart Phone", 3200.0, 32));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
       System.out.println("**************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("***********************");
    }
    }
