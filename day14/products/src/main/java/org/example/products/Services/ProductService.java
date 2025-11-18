package org.example.products.Services;


import org.example.products.Models.Category;
import org.example.products.Models.Product;
import org.example.products.Repositories.CategoryRepository;
import org.example.products.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product newProduct){
        return productRepository.save(newProduct);
    }

    public Product findProduct(Long id){
        Optional optional= productRepository.findById(id);
        if (optional.isPresent()){
            return (Product) optional.get();
        }
        return null;
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
