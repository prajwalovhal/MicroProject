package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private long custId;

    @Size(min = 2, message = "Customer name should be atleast 2 character")
    private String custName;

    private String custAddress;

    private long custContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date custDOB;

    @Email(message = "Email Id Must be valid")
    private String custEmailId;

    @Size(min = 4, message = "Password sholud be atleast 4 character")
    private String custPassword;

    private long productId;
}
