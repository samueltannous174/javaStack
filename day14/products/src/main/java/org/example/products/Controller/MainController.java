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
        return "redirect:/categories/new" ;
    }

    @GetMapping("product/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model){
        Product product= productService.findProduct(id);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);


        if (product == null){
            model.addAttribute("categories",categories);
            return "redirect:/" ;
        }


        List<Category> productCategories = product.getCategories();
        model.addAttribute("productCategories",productCategories);


        model.addAttribute("product", product);

        return "showProduct";
    }

    @PostMapping("/add_category")
    public String addCategoryToProduct(@RequestParam("productId") Long productId,
                                       @RequestParam("category") Long categoryId) {


        Product product = productService.findProduct(productId);
        Category category = categoryService.findCategory(categoryId);
        product.getCategories().add(category);
        productService.updateProduct(product);
        return "redirect:/product/"+productId;
    }

    @GetMapping("category/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model){
        Category category= categoryService.findCategory(id);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);

        if (category == null){
            model.addAttribute("products",products);
            return "redirect:/" ;
        }


        List<Product> productCategories = category.getProducts();
        model.addAttribute("productCategories",productCategories);


        model.addAttribute("category", category);

        return "showCategory";
    }

    @PostMapping("/add_product")
    public String addProductsToCategories(@RequestParam("categoryId") Long categoryId,
                                       @RequestParam("product") Long productId) {
        Product product = productService.findProduct(productId);
        Category category = categoryService.findCategory(categoryId);
        category.getProducts().add(product);
        categoryService.updateCategory(category);
        return "redirect:/category/"+ categoryId;
    }

}
