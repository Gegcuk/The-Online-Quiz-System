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
@Table(name = "JeopardyQuizzes")
public class JeopardyQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jeopardyQuizId;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getJeopardyQuizId() {
        return this.jeopardyQuizId;
    }

    public void setJeopardyQuizId(Long jeopardyQuizId) {
        this.jeopardyQuizId = jeopardyQuizId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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
