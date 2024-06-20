package com.gegcuk.online_quizzes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gegcuk.online_quizzes.model.JeopardyAnswer;
import com.gegcuk.online_quizzes.repository.JeopardyAnswerRepository;

@Service
public class JeopardyAnswerService {

    private final JeopardyAnswerRepository jeopardyAnswerRepository;

    @Autowired
    public JeopardyAnswerService(JeopardyAnswerRepository jeopardyAnswerRepository) {
        this.jeopardyAnswerRepository = jeopardyAnswerRepository;
    }

    public JeopardyAnswer createAnswer(JeopardyAnswer answer) {
        return jeopardyAnswerRepository.save(answer);
    }

    public List<JeopardyAnswer> findAllAnswers() {
        return jeopardyAnswerRepository.findAll();
    }

    public Optional<JeopardyAnswer> findAnswerById(Long id) {
        return jeopardyAnswerRepository.findById(id);
    }

    public void deleteAnswer(Long id) {
        jeopardyAnswerRepository.deleteById(id);
    }
}
