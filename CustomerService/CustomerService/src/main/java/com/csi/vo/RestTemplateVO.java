package com.csi.vo;

import com.csi.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateVO {

    private Customer customer;

    private Product product;


}
