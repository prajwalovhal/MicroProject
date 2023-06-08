package com.csi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private long productId;

    @Size(min = 2, message = "Product name atleast 2 character")
    private String productName;

    @Size(max = 4, message = "Product code should not more than 4 character")
    private String productCode;

    private double productPrice;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date productLaunchDate;
}
