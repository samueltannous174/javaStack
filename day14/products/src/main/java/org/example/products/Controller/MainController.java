package org.example.products.Controller;


import jakarta.validation.Valid;
import org.example.products.Models.Category;
import org.example.products.Models.Product;
import org.example.products.Services.CategoryService;
import org.example.products.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public MainController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String showHome(Model model){
        List<Product> products= productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("products",products);
        model.addAttribute("categories",categories);
        return "showHome";
    }

    @GetMapping("/products/new")
    public String showNewProducts(@ModelAttribute("product") Product product){
        return "newProduct";
    }
    @GetMapping("/categories/new")
    public String showNewCategory(@ModelAttribute("category") Category category){
        return "newCategory";
    }

    @PostMapping("/create_product")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if (result.hasErrors()){
            return "newProduct";
        }
        productService.createProduct(product);
        return "redirect:/" ;
    }
    @PostMapping("/create_category")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if (result.hasErrors()){
            return "newCategory";
        }
        categoryService.createCategory(category);
        return "redirect:/" ;
    }

    @GetMapping("product/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model){


        Product product= productService.findProduct(id);
        if (product == null){
            return "redirect:/" ;
        }



        List<Category> categories = categoryService.getAllCategories();
        Set<Category> productCategories = product.getCategories();
        model.addAttribute("productCategories",productCategories);
        categories.removeAll(productCategories);
        model.addAttribute("categories",categories);


        model.addAttribute("product", product);

        return "showProduct";
    }

    @PostMapping("/add_category")
    public String addCategoryToProduct(@RequestParam("productId") Long productId,
                                       @RequestParam("category") Long categoryId) {
        if (categoryId == null || productId == null){
            return "redirect: /";
        }


        Product product = productService.findProduct(productId);
        Category category = categoryService.findCategory(categoryId);
        product.getCategories().add(category);
        productService.updateProduct(product);
        return "redirect:/product/"+productId;
    }

    @GetMapping("category/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model){

        Category category= categoryService.findCategory(id);
        if (category == null){
            return "redirect:/" ;
        }


        List<Product> products = productService.getAllProducts();
        Set<Product> productCategories = category.getProducts();
        model.addAttribute("productCategories",productCategories);
        products.removeAll(productCategories);
        model.addAttribute("products",products);


        model.addAttribute("category", category);

        return "showCategory";
    }

    @PostMapping("/add_product")
    public String addProductsToCategories(@RequestParam("categoryId") Long categoryId,
                                       @RequestParam("product") Long productId) {
        if (categoryId == null || productId == null){
            return "redirect:/";
        }

        Product product = productService.findProduct(productId);
        Category category = categoryService.findCategory(categoryId);
        category.getProducts().add(product);
        categoryService.updateCategory(category);
        return "redirect:/category/"+ categoryId;
    }

}
