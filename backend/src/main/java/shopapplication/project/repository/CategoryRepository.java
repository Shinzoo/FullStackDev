package shopapplication.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shopapplication.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    void deleteCategoryById(Integer id);
    Optional<Category> findCategoryById(Integer id);
}
