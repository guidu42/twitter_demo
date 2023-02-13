package com.hb.guillaume_jason.service;

import com.hb.guillaume_jason.dto.CategoryDTO;
import com.hb.guillaume_jason.model.Category;
import com.hb.guillaume_jason.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findByIds(List<Integer> categoriesId) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(Integer categoryId : categoriesId) {
            Category category = this.categoryRepository.findById(categoryId);
            if (category != null) {
                categoryDTOS.add(new CategoryDTO(category.getId(), category.getLabel()));
            }
        }

        return categoryDTOS;
    }
}
