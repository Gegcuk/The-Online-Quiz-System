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

import com.gegcuk.online_quizzes.model.JeopardyQuiz;
import com.gegcuk.online_quizzes.repository.JeopardyQuizRepository;

@ExtendWith(MockitoExtension.class)
public class JeopardyQuizServiceTest {

    @Mock
    private JeopardyQuizRepository jeopardyQuizRepository;

    @InjectMocks
    private JeopardyQuizService jeopardyQuizService;

    @Test
    public void testCreateQuiz() {
        JeopardyQuiz quiz = new JeopardyQuiz();
        quiz.setTitle("Test Quiz");

        when(jeopardyQuizRepository.save(any(JeopardyQuiz.class))).thenReturn(quiz);

        JeopardyQuiz createdQuiz = jeopardyQuizService.createQuiz(quiz);

        assertNotNull(createdQuiz);
        assertEquals("Test Quiz", createdQuiz.getTitle());
        verify(jeopardyQuizRepository, times(1)).save(quiz);
    }

    @Test
    public void testFindAllQuizzes() {
        JeopardyQuiz quiz = new JeopardyQuiz();
        quiz.setTitle("Test Quiz");

        List<JeopardyQuiz> quizList = Collections.singletonList(quiz);

        when(jeopardyQuizRepository.findAll()).thenReturn(quizList);

        List<JeopardyQuiz> result = jeopardyQuizService.findAllQuizzes();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Quiz", result.get(0).getTitle());
        verify(jeopardyQuizRepository, times(1)).findAll();
    }

    @Test
    public void testFindQuizById() {
        JeopardyQuiz quiz = new JeopardyQuiz();
        quiz.setTitle("Test Quiz");

        when(jeopardyQuizRepository.findById(1L)).thenReturn(Optional.of(quiz));

        Optional<JeopardyQuiz> result = jeopardyQuizService.findQuizById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Quiz", result.get().getTitle());
        verify(jeopardyQuizRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteQuiz() {
        jeopardyQuizService.deleteQuiz(1L);
        verify(jeopardyQuizRepository, times(1)).deleteById(1L);
    }
}
