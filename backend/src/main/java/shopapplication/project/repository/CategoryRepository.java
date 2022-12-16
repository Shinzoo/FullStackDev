package shopapplication.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopapplication.project.entities.Product;
import shopapplication.project.entities.Shop;

@Repository
public interface CategoryRepository extends JpaRepository<Shop, Long> {
    Product findByName(String name);
  }
