package org.example.diary.repository;

import org.example.diary.service.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {
}
