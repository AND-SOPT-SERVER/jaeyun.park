package org.example.diary.repository;

import jakarta.persistence.*;
import java.time.LocalDate;
import org.example.diary.service.Diary;

@Entity
public class DiaryJpaEntity {

    protected DiaryJpaEntity() {
    }

    public DiaryJpaEntity(String title, String content, LocalDate now) {
        this.title = title;
        this.content = content;
        this.createdAt = now;
    }

    @Id
    @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDate createdAt;


    public static DiaryJpaEntity from(Diary diary) {
        return new DiaryJpaEntity(diary.getTitle(), diary.getContent(), LocalDate.now());
    }

    public Diary toModel() {
        return new Diary(id, title, content, createdAt.toString());
    }

    public DiaryJpaEntity update(DiaryJpaEntity diaryJpaEntity) {
        this.title = diaryJpaEntity.title;
        this.content = diaryJpaEntity.content;
        return this;
    }
}
