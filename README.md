# SIMPLE (CRUD) REST API WEB SITE FOR ORDERING COFFEE AND DONUT

# Pages
<img align="center" alt="Java " width="550px" src="https://github.com/itsabdiev/webpizza/blob/main/Main.PNG" />  <br />
    <br />   
    
<img align="center" alt="Java " width="550px" src="https://github.com/itsabdiev/webpizza/blob/main/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA.PNG" />  <br />
    <br />   
    
# ERD
<img align="center" alt="Java " width="550px" src="https://github.com/itsabdiev/webpizza/blob/main/Untitled.png" />  <br />
    <br />   

### Languages and Tools:
[<img align="left" alt="Java " width="36px" src="http://www.thymeleaf.org/images/thymeleaf.png" />]
[<img align="left" alt="Java " width="36px" src="https://symbols-electrical.getvecta.com/stencil_96/69_spring-framework-icon.d563816ce9.jpg" />]
[<img align="left" alt="Scene Builder " width="36px" src="https://coderlessons.com/wp-content/uploads/images/stp/426c04c3f3e6c1621b2b2bf9dc3a7aaf.jpg" />] <br /> 

<br />

---

# Code

* ProductController.java
```java

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


    @GetMapping({"/main","/"})
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
```


