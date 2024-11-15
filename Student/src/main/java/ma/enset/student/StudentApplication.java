package ma.enset.student;

import ma.enset.student.entities.Product;
import ma.enset.student.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

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

        Optional<Product> optionalProduct = productRepository.findById(1L);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            System.out.println("**************");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQuantity());
            System.out.println("***********************");
        } else {
            System.out.println("Produit avec ID 1 non trouvé.");
        }

        System.out.println("-----------------------");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p -> {
            System.out.println(p);
        });

        System.out.println("-----------------------");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p -> {
            System.out.println(p);
        });

        System.out.println("-----------------------");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(3000.0);
        productList3.forEach(p -> {
            System.out.println(p);
        });
    }
}
