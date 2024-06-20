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
@Table(name = "JeopardyQuestions")
public class JeopardyQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private JeopardyCategory jeopardyCategory;

    @Column(nullable = false)
    private String questionText;

    @Column(nullable = false)
    private int points;

    @Column(nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public JeopardyCategory getJeopardyCategory() {
        return this.jeopardyCategory;
    }

    public void setJeopardyCategory(JeopardyCategory jeopardyCategory) {
        this.jeopardyCategory = jeopardyCategory;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
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
