package com.csi.service;

import com.csi.dao.ProductDaoImpl;
import com.csi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    ProductDaoImpl productDaoImpl;


    public Product saveProductData(Product product) {
        return productDaoImpl.saveData(product);
    }

    public List<Product> getAllData() {
        return productDaoImpl.getAllData();
    }

    public Optional<Product> getDataById(long productId) {
       return productDaoImpl.getDataById(productId);
    }

    public List<Product> getDataByProductName(String productName) {
        return productDaoImpl.getDataByProductName(productName);
    }

    public List<Product> sortProductByPrice() {
        return productDaoImpl.sortbyProductPrice();
    }

    public Product updateData(Product product) {
        return productDaoImpl.updateData(product);
    }

    public void deleteDataById(long productId) {
        productDaoImpl.deleteDataById(productId);
    }
}
