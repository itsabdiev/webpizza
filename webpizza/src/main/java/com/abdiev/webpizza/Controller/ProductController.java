package com.abdiev.webpizza.Controller;


import com.abdiev.webpizza.Entity.Product;
import com.abdiev.webpizza.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/main")
    public String getMain(Model model){
        return "main";
    }
    @GetMapping("/coffix")
    public String getProducts(Model model){
        model.addAttribute("list",productService.getProducts());
        return "product";
    }

    @GetMapping("/coffix/addform")
    public String saveProductForm(Model model){
        model.addAttribute("product",new Product());
        return "productadd";
    }

    @PostMapping("/coffix/addproduct")
    public String saveProduct(@ModelAttribute Product product){
        productService.saveProduct(product);
        return "redirect:/coffix";
    }


    @GetMapping("/coffix/updateform/{id}")
    public String updateProductForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "productupdate";
    }

    @PatchMapping("/coffix/updateproduct/{id}")
    public String updateProduct(@PathVariable("id") Long id,@ModelAttribute Product product){
        productService.updateProduct(id,product);
        return "redirect:/coffix";
    }

    @DeleteMapping("/coffix/deleteproduct/{id}")
    public String updateProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/coffix";
    }
    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
