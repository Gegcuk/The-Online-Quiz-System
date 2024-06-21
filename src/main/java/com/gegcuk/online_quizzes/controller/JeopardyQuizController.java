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

import com.gegcuk.online_quizzes.model.JeopardyQuiz;
import com.gegcuk.online_quizzes.service.JeopardyQuizService;

@RestController
@RequestMapping("/api/jeopardy/quizzes")
public class JeopardyQuizController {

    private final JeopardyQuizService jeopardyQuizService;

    @Autowired
    public JeopardyQuizController(JeopardyQuizService jeopardyQuizService) {
        this.jeopardyQuizService = jeopardyQuizService;
    }

    @PostMapping
    public ResponseEntity<JeopardyQuiz> createQuiz(@RequestBody JeopardyQuiz quiz) {
        JeopardyQuiz createdQuiz = jeopardyQuizService.createQuiz(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }

    @GetMapping
    public ResponseEntity<List<JeopardyQuiz>> getAllQuizzes() {
        List<JeopardyQuiz> quizzes = jeopardyQuizService.findAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JeopardyQuiz> getQuizById(@PathVariable Long id) {
        Optional<JeopardyQuiz> quiz = jeopardyQuizService.findQuizById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        jeopardyQuizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
