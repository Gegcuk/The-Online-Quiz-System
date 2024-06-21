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

import com.gegcuk.online_quizzes.model.JeopardyAnswer;
import com.gegcuk.online_quizzes.repository.JeopardyAnswerRepository;

@ExtendWith(MockitoExtension.class)
public class JeopardyAnswerServiceTest {

    @Mock
    private JeopardyAnswerRepository jeopardyAnswerRepository;

    @InjectMocks
    private JeopardyAnswerService jeopardyAnswerService;

    @Test
    public void testCreateAnswer() {
        JeopardyAnswer answer = new JeopardyAnswer();
        answer.setAnswerText("Test Answer");
        answer.setIsCorrect(true);

        when(jeopardyAnswerRepository.save(any(JeopardyAnswer.class))).thenReturn(answer);

        JeopardyAnswer createdAnswer = jeopardyAnswerService.createAnswer(answer);

        assertNotNull(createdAnswer);
        assertEquals("Test Answer", createdAnswer.getAnswerText());
        assertTrue(createdAnswer.isIsCorrect());
        verify(jeopardyAnswerRepository, times(1)).save(answer);
    }

    @Test
    public void testFindAllAnswers() {
        JeopardyAnswer answer = new JeopardyAnswer();
        answer.setAnswerText("Test Answer");

        List<JeopardyAnswer> answerList = Collections.singletonList(answer);

        when(jeopardyAnswerRepository.findAll()).thenReturn(answerList);

        List<JeopardyAnswer> result = jeopardyAnswerService.findAllAnswers();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Answer", result.get(0).getAnswerText());
        verify(jeopardyAnswerRepository, times(1)).findAll();
    }

    @Test
    public void testFindAnswerById() {
        JeopardyAnswer answer = new JeopardyAnswer();
        answer.setAnswerText("Test Answer");

        when(jeopardyAnswerRepository.findById(1L)).thenReturn(Optional.of(answer));

        Optional<JeopardyAnswer> result = jeopardyAnswerService.findAnswerById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Answer", result.get().getAnswerText());
        verify(jeopardyAnswerRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteAnswer() {
        jeopardyAnswerService.deleteAnswer(1L);
        verify(jeopardyAnswerRepository, times(1)).deleteById(1L);
    }
}
