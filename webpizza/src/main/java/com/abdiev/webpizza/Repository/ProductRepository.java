package com.abdiev.webpizza.Repository;

import com.abdiev.webpizza.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE products set name =?1  , description = ?2 , price = ?3 , picture = ?4 WHERE id = ?5",nativeQuery = true)
    void updateProduct(String name,String description,Integer price,String picture,Long id);
}
