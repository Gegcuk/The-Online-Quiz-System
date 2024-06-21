package com.gegcuk.online_quizzes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gegcuk.online_quizzes.model.JeopardyCategory;
import com.gegcuk.online_quizzes.service.JeopardyCategoryService;

@RestController
@RequestMapping("/api/jeopardy/categories")
public class JeopardyCategoryController {

    private final JeopardyCategoryService jeopardyCategoryService;

    @Autowired
    public JeopardyCategoryController(JeopardyCategoryService jeopardyCategoryService) {
        this.jeopardyCategoryService = jeopardyCategoryService;
    }

    @PostMapping
    public ResponseEntity<JeopardyCategory> createCategory(@RequestBody JeopardyCategory category) {
        JeopardyCategory createdCategory = jeopardyCategoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping
    public ResponseEntity<List<JeopardyCategory>> getAllCategories() {
        List<JeopardyCategory> categories = jeopardyCategoryService.findAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JeopardyCategory> getCategoryById(@PathVariable Long id) {
        Optional<JeopardyCategory> category = jeopardyCategoryService.findCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        jeopardyCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
