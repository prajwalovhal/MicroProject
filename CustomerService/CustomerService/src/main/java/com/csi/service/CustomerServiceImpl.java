package com.csi.service;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerDaoImpl customerDaoImpl;


    public Customer signUp(Customer customer) {
        return customerDaoImpl.signUp(customer);
    }

    public RestTemplateVO getDataById(long custId) {
        return customerDaoImpl.getDataById(custId);
    }

    public boolean signIn(String custEmailId, String custPassword) {
        return customerDaoImpl.signIn(custEmailId, custPassword);
    }

    public Customer getDataByEmailId(String custEmailId) {
        return customerDaoImpl.getDatabyEmailId(custEmailId);
    }

    public Customer updateData(Customer customer) {
        return customerDaoImpl.updateData(customer);
    }

    public void deleteData(long custId) {

        customerDaoImpl.deleteData(custId);
    }
}
