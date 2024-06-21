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

import com.gegcuk.online_quizzes.model.JeopardyQuestion;
import com.gegcuk.online_quizzes.repository.JeopardyQuestionRepository;

@ExtendWith(MockitoExtension.class)
public class JeopardyQuestionServiceTest {

    @Mock
    private JeopardyQuestionRepository jeopardyQuestionRepository;

    @InjectMocks
    private JeopardyQuestionService jeopardyQuestionService;

    @Test
    public void testCreateQuestion() {
        JeopardyQuestion question = new JeopardyQuestion();
        question.setQuestionText("Test Question");
        question.setPoints(100);

        when(jeopardyQuestionRepository.save(any(JeopardyQuestion.class))).thenReturn(question);

        JeopardyQuestion createdQuestion = jeopardyQuestionService.createQuestion(question);

        assertNotNull(createdQuestion);
        assertEquals("Test Question", createdQuestion.getQuestionText());
        assertEquals(100, createdQuestion.getPoints());
        verify(jeopardyQuestionRepository, times(1)).save(question);
    }

    @Test
    public void testFindAllQuestions() {
        JeopardyQuestion question = new JeopardyQuestion();
        question.setQuestionText("Test Question");

        List<JeopardyQuestion> questionList = Collections.singletonList(question);

        when(jeopardyQuestionRepository.findAll()).thenReturn(questionList);

        List<JeopardyQuestion> result = jeopardyQuestionService.findAllQuestions();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Question", result.get(0).getQuestionText());
        verify(jeopardyQuestionRepository, times(1)).findAll();
    }

    @Test
    public void testFindQuestionById() {
        JeopardyQuestion question = new JeopardyQuestion();
        question.setQuestionText("Test Question");

        when(jeopardyQuestionRepository.findById(1L)).thenReturn(Optional.of(question));

        Optional<JeopardyQuestion> result = jeopardyQuestionService.findQuestionById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Question", result.get().getQuestionText());
        verify(jeopardyQuestionRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteQuestion() {
        jeopardyQuestionService.deleteQuestion(1L);
        verify(jeopardyQuestionRepository, times(1)).deleteById(1L);
    }
}

