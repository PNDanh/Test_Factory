package com.example.bai_test.response;

import com.example.bai_test.entity.Brand;
import com.example.bai_test.entity.Status;
import com.example.bai_test.entity.SubCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
public class ProductResponsee {
    private Long id;

    @NotBlank(message = "Không được để trống tên SP")
    private String productName;
    @NotBlank(message = "Không được để trống màu sắc")
    private String color;
    @NotNull(message ="Số lượng không được rỗng")
    @PositiveOrZero(message = "Số lượng phải là một số dương")
    private Long quantity;

    @NotNull(message = "Giá nhập không được rỗng")
    @PositiveOrZero(message = "Giá nhập phải là một số dương")
    private Double sellPrice;
    @NotNull(message = "Giá bán không được rỗng")
    @PositiveOrZero(message = "Giá bán phải là một số dương")
    private Double originPrice;
    private String description;

    @NotNull
    private Status status;

    @NotNull
    private SubCategory subCategory;

    private List<Brand> product_Brand;

}
