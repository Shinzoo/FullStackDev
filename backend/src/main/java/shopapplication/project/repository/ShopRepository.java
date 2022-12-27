package shopapplication.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shopapplication.project.entities.Shop;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
   void deleteShopById(Integer id);
   Optional<Shop> findShopById(Integer id); 
}
