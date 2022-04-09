package com.abdiev.webpizza.Service;

import com.abdiev.webpizza.Entity.Product;
import com.abdiev.webpizza.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts() {

        return productRepository.findAll().stream().sorted(Comparator.comparing(Product::getId)).collect(Collectors.toList());
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    public void updateProduct(Long id,Product product) {
        productRepository.updateProduct(product.getName(),product.getDescription(),product.getPrice(),product.getPicture(),id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
