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
@Table(name = "JeopardyCategories")
public class JeopardyCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "jeopardy_quiz_id", nullable = false)
    private JeopardyQuiz jeopardyQuiz;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public JeopardyQuiz getJeopardyQuiz() {
        return this.jeopardyQuiz;
    }

    public void setJeopardyQuiz(JeopardyQuiz jeopardyQuiz) {
        this.jeopardyQuiz = jeopardyQuiz;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
