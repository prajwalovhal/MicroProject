package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;


    @PostMapping("/")
    public ResponseEntity<Product> saveData(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productServiceImpl.saveProductData(product), HttpStatus.CREATED);
    }

    @GetMapping("/getallldata")
    public ResponseEntity<List<Product>> getAllData() {
        return ResponseEntity.ok(productServiceImpl.getAllData());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> getDataById(@PathVariable long productId) {
        return ResponseEntity.ok(productServiceImpl.getDataById(productId));
    }

    @GetMapping("/getdatabyname/{productName}")
    public ResponseEntity<List<Product>> getDataByProductName(@PathVariable String productName) {
        return ResponseEntity.ok(productServiceImpl.getDataByProductName(productName));
    }

    @GetMapping("/sortproductbyprice")
    public ResponseEntity<List<Product>> sortProductByPrice() {
        return ResponseEntity.ok(productServiceImpl.sortProductByPrice());
    }

    @PutMapping("/updatedata/{productId}")
    public ResponseEntity<Product> updateData(@PathVariable long productId, @RequestBody Product product) {
        Product product1 = productServiceImpl.getDataById(productId).orElseThrow(() -> new RecordNotFoundException("Product Id Does not Exist")
        );

        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductCode(product.getProductCode());
        product1.setProductLaunchDate(product.getProductLaunchDate());

        return ResponseEntity.ok(productServiceImpl.updateData(product1));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteDataById(@PathVariable long productId) {
        productServiceImpl.deleteDataById(productId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }


}
