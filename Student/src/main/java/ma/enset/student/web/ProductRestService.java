package ma.enset.student.web;

import ma.enset.student.entities.Product;
import ma.enset.student.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // Indique que cette classe est un contrôleur REST
public class ProductRestService {

    @Autowired
    private ProductRepository productRepository;

    // Récupère tous les produits
    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    // Récupère un produit par son ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();  // Retourne une réponse 404 si le produit n'est pas trouvé
        }
        return ResponseEntity.ok(product);  // Retourne une réponse 200 avec le produit
    }
}
