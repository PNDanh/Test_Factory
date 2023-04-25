package com.example.bai_test.repository;

import com.example.bai_test.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

    @Query("SELECT Sub from SubCategory Sub  where Sub.category.id = ?1")
    List<SubCategory> getAllSubById(Long id);
}
