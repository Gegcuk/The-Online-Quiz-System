package com.gegcuk.online_quizzes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JeopardyAnswers")
public class JeopardyAnswer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long answerId;

        @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private JeopardyQuestion question;

    @Column(nullable = false)
    private String answerText;

    @Column(nullable = false)
    private boolean isCorrect;

    @Column(nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, insertable = false)
    private LocalDateTime updatedAt;


    public Long getAnswerId() {
        return this.answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public JeopardyQuestion getQuestion() {
        return this.question;
    }

    public void setQuestion(JeopardyQuestion question) {
        this.question = question;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isIsCorrect() {
        return this.isCorrect;
    }

    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
