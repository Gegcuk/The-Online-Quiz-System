package com.gegcuk.online_quizzes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gegcuk.online_quizzes.model.JeopardyQuestion;
import com.gegcuk.online_quizzes.repository.JeopardyQuestionRepository;

@Service
public class JeopardyQuestionService {

    private final JeopardyQuestionRepository jeopardyQuestionRepository;

    @Autowired
    public JeopardyQuestionService(JeopardyQuestionRepository jeopardyQuestionRepository) {
        this.jeopardyQuestionRepository = jeopardyQuestionRepository;
    }

    public JeopardyQuestion createQuestion(JeopardyQuestion question) {
        return jeopardyQuestionRepository.save(question);
    }

    public List<JeopardyQuestion> findAllQuestions() {
        return jeopardyQuestionRepository.findAll();
    }

    public Optional<JeopardyQuestion> findQuestionById(Long id) {
        return jeopardyQuestionRepository.findById(id);
    }

    public void deleteQuestion(Long id) {
        jeopardyQuestionRepository.deleteById(id);
    }
}

