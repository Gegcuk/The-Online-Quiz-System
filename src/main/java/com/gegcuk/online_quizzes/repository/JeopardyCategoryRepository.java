package com.gegcuk.online_quizzes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gegcuk.online_quizzes.model.JeopardyCategory;

@Repository
public interface JeopardyCategoryRepository extends JpaRepository<JeopardyCategory, Long> {
}

