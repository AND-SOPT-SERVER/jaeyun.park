package org.example.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryJpaRepository extends JpaRepository<DiaryJpaEntity, Long> {
}
