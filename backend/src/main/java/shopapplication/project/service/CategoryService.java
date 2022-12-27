package shopapplication.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopapplication.project.entities.Category;
import shopapplication.project.exceptions.CategoryNotFoundException;
import shopapplication.project.repository.CategoryRepository;

@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category findCategoryById(Integer id){
        return categoryRepository.findCategoryById(id)
                    .orElseThrow(() -> new CategoryNotFoundException("Category by id" + id + " was not found"));
    }

    public void deleteCategory(Integer id){
        categoryRepository.deleteCategoryById(id);
    }
}
