package org.example.products.Services;

import org.example.products.Models.Category;
import org.example.products.Models.Product;
import org.example.products.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category newCategory){
       return categoryRepository.save(newCategory);
    }

    public Category findCategory(Long id){
        Optional optional= categoryRepository.findById(id);
        if (optional.isPresent()){
            return (Category) optional.get();
        }
        return null;
    }

    public List<Category> getAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

}
