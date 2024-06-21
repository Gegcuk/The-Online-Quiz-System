package com.gegcuk.online_quizzes.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gegcuk.online_quizzes.model.JeopardyCategory;
import com.gegcuk.online_quizzes.repository.JeopardyCategoryRepository;

@ExtendWith(MockitoExtension.class)
public class JeopardyCategoryServiceTest {

    @Mock
    private JeopardyCategoryRepository jeopardyCategoryRepository;

    @InjectMocks
    private JeopardyCategoryService jeopardyCategoryService;

    @Test
    public void testCreateCategory() {
        JeopardyCategory category = new JeopardyCategory();
        category.setName("Test Category");

        when(jeopardyCategoryRepository.save(any(JeopardyCategory.class))).thenReturn(category);

        JeopardyCategory createdCategory = jeopardyCategoryService.createCategory(category);

        assertNotNull(createdCategory);
        assertEquals("Test Category", createdCategory.getName());
        verify(jeopardyCategoryRepository, times(1)).save(category);
    }

    @Test
    public void testFindAllCategories() {
        JeopardyCategory category = new JeopardyCategory();
        category.setName("Test Category");

        List<JeopardyCategory> categoryList = Collections.singletonList(category);

        when(jeopardyCategoryRepository.findAll()).thenReturn(categoryList);

        List<JeopardyCategory> result = jeopardyCategoryService.findAllCategories();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Category", result.get(0).getName());
        verify(jeopardyCategoryRepository, times(1)).findAll();
    }

    @Test
    public void testFindCategoryById() {
        JeopardyCategory category = new JeopardyCategory();
        category.setName("Test Category");

        when(jeopardyCategoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Optional<JeopardyCategory> result = jeopardyCategoryService.findCategoryById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Category", result.get().getName());
        verify(jeopardyCategoryRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteCategory() {
        jeopardyCategoryService.deleteCategory(1L);
        verify(jeopardyCategoryRepository, times(1)).deleteById(1L);
    }
}
