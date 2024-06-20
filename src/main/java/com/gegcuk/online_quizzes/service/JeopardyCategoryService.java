package com.gegcuk.online_quizzes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gegcuk.online_quizzes.model.JeopardyCategory;
import com.gegcuk.online_quizzes.repository.JeopardyCategoryRepository;

@Service
public class JeopardyCategoryService {

    private final JeopardyCategoryRepository jeopardyCategoryRepository;

    @Autowired
    public JeopardyCategoryService(JeopardyCategoryRepository jeopardyCategoryRepository) {
        this.jeopardyCategoryRepository = jeopardyCategoryRepository;
    }

    public JeopardyCategory createCategory(JeopardyCategory category) {
        return jeopardyCategoryRepository.save(category);
    }

    public List<JeopardyCategory> findAllCategories() {
        return jeopardyCategoryRepository.findAll();
    }

    public Optional<JeopardyCategory> findCategoryById(Long id) {
        return jeopardyCategoryRepository.findById(id);
    }

    public void deleteCategory(Long id) {
        jeopardyCategoryRepository.deleteById(id);
    }
}

