package com.csi.dao;

import com.csi.model.Product;
import com.csi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductDaoImpl {

    @Autowired
    ProductRepo productRepoImpl;


    public Product saveData(Product product) {
        return productRepoImpl.save(product);
    }

    public List<Product> getAllData() {
        return productRepoImpl.findAll();
    }

    public Optional<Product> getDataById(long productId) {
      return productRepoImpl.findById(productId);
    }

    public List<Product> getDataByProductName(String productName) {
        return productRepoImpl.findByProductName(productName);
    }

    public List<Product> sortbyProductPrice() {
        return productRepoImpl.findAll().stream().sorted(Comparator.comparingDouble(Product::getProductPrice)).collect(Collectors.toList());
    }

    public Product updateData(Product product) {
        return productRepoImpl.save(product);
    }

    public void deleteDataById(long productId) {
        productRepoImpl.deleteById(productId);
    }
}
