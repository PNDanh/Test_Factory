package com.example.bai_test.service.imp;

import com.example.bai_test.config.mapper.BrandMapper;
import com.example.bai_test.response.BranResponse;
import com.example.bai_test.entity.Brand;
import com.example.bai_test.repository.BrandRepository;
import com.example.bai_test.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public List<BranResponse> getAll() {
        List<BranResponse> branResponses = new ArrayList<>();
        for (Brand brand : brandRepository.findAll()) {
            branResponses.add(brandMapper.convertToDTO(brand));
        }
        return branResponses;
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public BranResponse getOne(Long id) {
        return brandMapper.convertToDTO(brandRepository.findById(id).get());
    }

}

