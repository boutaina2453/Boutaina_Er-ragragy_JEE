package ma.enset.student.repository;

import ma.enset.student.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContains(String name);

    List<Product> findByPriceGreaterThan(Double price);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :keyword")
    List<Product> search(@Param("keyword") String keyword);
}
