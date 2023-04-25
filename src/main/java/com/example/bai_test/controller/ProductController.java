package com.example.bai_test.controller;

import com.example.bai_test.response.BranResponse;
import com.example.bai_test.response.CategoryResponse;
import com.example.bai_test.response.ProductResponsee;
import com.example.bai_test.response.StatusResponse;
import com.example.bai_test.response.SubCategoryResponse;
import com.example.bai_test.exception.notfound.Exception;
import com.example.bai_test.service.BrandService;
import com.example.bai_test.service.CategoryService;
import com.example.bai_test.service.ProductService;
import com.example.bai_test.service.StatusService;
import com.example.bai_test.service.SubCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/baitest")
public class ProductController {

    @Autowired
    private StatusService statusService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/listStatus")
    public List<StatusResponse> getAllStatus() {
        return statusService.getAll();
    }

    @GetMapping("/listCategory")
    public List<CategoryResponse> getAllCategory() {
        return categoryService.getAll();
    }

    @GetMapping("/listBrand")
    public List<BranResponse> getAllBrand() {
        return brandService.getAll();
    }

    @GetMapping("/listSubCategory")
    public List<SubCategoryResponse> getAllSubCategory() {
        return subCategoryService.getAll();
    }

    @GetMapping("/listSubCategory/{id}")
    public List<SubCategoryResponse> getAllSubById(@PathVariable("id") Long id) {
        return subCategoryService.getAllSubById(id);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponsee>> getAllProduct() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponsee> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getOne(id));
    }

    @GetMapping("/listBrand/{id}")
    public BranResponse getOneBrById(@PathVariable("id") Long id){
        return brandService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponsee> add(@Valid @RequestBody ProductResponsee productResponsee) {
        productService.add(productResponsee);
        return ResponseEntity.ok(productResponsee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponsee> update(@PathVariable("id") Long id, @RequestBody ProductResponsee productResponsee) {
        productService.update(id,productResponsee);
        return ResponseEntity.ok(productResponsee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }


}
