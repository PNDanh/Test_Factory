package com.example.bai_test.service.imp;

import com.example.bai_test.exception.notfound.Exception;
import com.example.bai_test.response.ProductResponsee;
import com.example.bai_test.entity.Product;
import com.example.bai_test.config.mapper.ProductMapper;
import com.example.bai_test.repository.ProductRepository;
import com.example.bai_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<ProductResponsee> getAll() {
        List<ProductResponsee> productRespons = new ArrayList<>();
        for (Product pr : productRepository.findAll()) {
            productRespons.add(productMapper.convertToDTO(pr));
        }
        return productRespons;
    }

    @Override
    public ProductResponsee add(ProductResponsee productResponsee) {
        if (getOneByID(productResponsee.getId()) != null) {
            throw new Exception("Sản Phẩm đã tồn tại");
        }
        return productMapper.convertToDTO(productRepository.save(productMapper.convertToEntity(productResponsee)));
    }

    @Override
    public ProductResponsee getOne(Long id) {
        if (getOneByID(id) == null) {
            throw new Exception("Không tồn tại Sản Phẩm");
        }
        return productMapper.convertToDTO(productRepository.findById(id).get());
    }

    @Override
    public void update(Long id, ProductResponsee productResponsee) {
        if (getOneByID(id) == null) {
            throw new Exception("Không tồn tại Sản Phẩm để cập nhật");
        }
        productRepository.save(productMapper.convertToEntity(productResponsee));
    }

    @Override
    public void delete(Long id) {
        if (getOneByID(id) == null) {
            throw new Exception("Không tồn tại Sản Phẩm để xóa");
        }
        productRepository.deleteProductBrand(id);
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponsee getOneByID(Long id) {
        return getAll().stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

}
