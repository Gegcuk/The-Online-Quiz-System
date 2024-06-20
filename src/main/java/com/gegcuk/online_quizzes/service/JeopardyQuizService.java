package com.gegcuk.online_quizzes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gegcuk.online_quizzes.model.JeopardyQuiz;
import com.gegcuk.online_quizzes.repository.JeopardyQuizRepository;

@Service
public class JeopardyQuizService {

    private final JeopardyQuizRepository jeopardyQuizRepository;

    @Autowired
    public JeopardyQuizService(JeopardyQuizRepository jeopardyQuizRepository) {
        this.jeopardyQuizRepository = jeopardyQuizRepository;
    }

    public JeopardyQuiz createQuiz(JeopardyQuiz quiz) {
        return jeopardyQuizRepository.save(quiz);
    }

    public List<JeopardyQuiz> findAllQuizzes() {
        return jeopardyQuizRepository.findAll();
    }

    public Optional<JeopardyQuiz> findQuizById(Long id) {
        return jeopardyQuizRepository.findById(id);
    }

    public void deleteQuiz(Long id) {
        jeopardyQuizRepository.deleteById(id);
    }

}
