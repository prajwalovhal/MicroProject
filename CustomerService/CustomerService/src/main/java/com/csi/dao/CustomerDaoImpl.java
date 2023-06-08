package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.vo.Product;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    @Autowired
    RestTemplate restTemplate;


    public Customer signUp(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public RestTemplateVO getDataById(long custId) {

        RestTemplateVO restTemplateVO = new RestTemplateVO();

        Customer customer = customerRepoImpl.findByCustId(custId);

        Product product = restTemplate.getForObject("http://ProductService/products/"+customer.getProductId(), Product.class);

        restTemplateVO.setCustomer(customer);
        restTemplateVO.setProduct(product);

        return restTemplateVO;

    }

    public boolean signIn(String custEmailId, String custPassword) {
        boolean status = false;

        for(Customer customer: customerRepoImpl.findAll()){
            if(customer.getCustEmailId().equals(custEmailId)
            && customer.getCustPassword().equals(custPassword)){
                status= true;
            }
        }

        return status;
    }

    public Customer getDatabyEmailId(String custEmailId) {

        return customerRepoImpl.findByCustEmailId(custEmailId);
    }

    public Customer updateData(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public void deleteData(long custId) {
        customerRepoImpl.deleteById(custId);
    }
}
