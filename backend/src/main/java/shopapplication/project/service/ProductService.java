package shopapplication.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopapplication.project.entities.Product;
import shopapplication.project.exceptions.ProductNotFoundException;
import shopapplication.project.repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductById(Integer id){
        return productRepository.findProductById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product by id" + id + " was not found"));
    }

    public void deleteProduct(Integer id){
        productRepository.deleteProductById(id);
    }
}
