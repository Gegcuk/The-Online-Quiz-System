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

import com.gegcuk.online_quizzes.model.JeopardyQuestion;
import com.gegcuk.online_quizzes.service.JeopardyQuestionService;

@RestController
@RequestMapping("/api/jeopardy/questions")
public class JeopardyQuestionController {

    private final JeopardyQuestionService jeopardyQuestionService;

    @Autowired
    public JeopardyQuestionController(JeopardyQuestionService jeopardyQuestionService) {
        this.jeopardyQuestionService = jeopardyQuestionService;
    }

    @PostMapping
    public ResponseEntity<JeopardyQuestion> createQuestion(@RequestBody JeopardyQuestion question) {
        JeopardyQuestion createdQuestion = jeopardyQuestionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    @GetMapping
    public ResponseEntity<List<JeopardyQuestion>> getAllQuestions() {
        List<JeopardyQuestion> questions = jeopardyQuestionService.findAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JeopardyQuestion> getQuestionById(@PathVariable Long id) {
        Optional<JeopardyQuestion> question = jeopardyQuestionService.findQuestionById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        jeopardyQuestionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
