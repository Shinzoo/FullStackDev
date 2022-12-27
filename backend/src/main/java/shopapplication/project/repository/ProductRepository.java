package shopapplication.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shopapplication.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    void deleteProductById(Integer id);
    Optional<Product> findProductById(Integer id);
}
