package com.example.bai_test.response;

import com.example.bai_test.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BranResponse {
    private Long id;
    private String brandName;
    private List<Product> brand_product;


}
