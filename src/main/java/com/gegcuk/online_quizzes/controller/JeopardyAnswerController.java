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

import com.gegcuk.online_quizzes.model.JeopardyAnswer;
import com.gegcuk.online_quizzes.service.JeopardyAnswerService;

@RestController
@RequestMapping("/api/jeopardy/answers")
public class JeopardyAnswerController {

    private final JeopardyAnswerService jeopardyAnswerService;

    @Autowired
    public JeopardyAnswerController(JeopardyAnswerService jeopardyAnswerService) {
        this.jeopardyAnswerService = jeopardyAnswerService;
    }

    @PostMapping
    public ResponseEntity<JeopardyAnswer> createAnswer(@RequestBody JeopardyAnswer answer) {
        JeopardyAnswer createdAnswer = jeopardyAnswerService.createAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping
    public ResponseEntity<List<JeopardyAnswer>> getAllAnswers() {
        List<JeopardyAnswer> answers = jeopardyAnswerService.findAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JeopardyAnswer> getAnswerById(@PathVariable Long id) {
        Optional<JeopardyAnswer> answer = jeopardyAnswerService.findAnswerById(id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        jeopardyAnswerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
