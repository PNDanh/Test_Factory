package com.example.bai_test.response;

import com.example.bai_test.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategoryResponse {

    private Long id;
    private String subCateCode;
    private String subCateName;
    private Category category;

}
