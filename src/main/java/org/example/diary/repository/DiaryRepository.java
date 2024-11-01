package org.example.diary.repository;

import java.util.List;
import java.util.Optional;
import org.example.diary.service.Diary;
import org.example.diary.service.DiaryPersistence;
import org.springframework.stereotype.Repository;

@Repository
public class DiaryRepository implements DiaryPersistence {
    private final DiaryJpaRepository diaryJpaRepository;

    public DiaryRepository(final DiaryJpaRepository diaryJpaRepository) {
        this.diaryJpaRepository = diaryJpaRepository;
    }

    @Override
    public Diary save(final Diary diary) {
        return diaryJpaRepository.save(DiaryJpaEntity.from(diary)).toModel();
    }

    @Override
    public Optional<Diary> findById(final long id) {
        return diaryJpaRepository.findById(id).map(DiaryJpaEntity::toModel);
    }

    @Override
    public void deleteById(final long id) {
        diaryJpaRepository.deleteById(id);
    }

    @Override
    public List<Diary> findAll() {
        return diaryJpaRepository.findAll().stream().map(DiaryJpaEntity::toModel).toList();
    }

    @Override
    public Optional<Diary> update(final long id, final Diary diary) {
        return diaryJpaRepository.findById(id)
                .map(entity -> entity.update(DiaryJpaEntity.from(diary)).toModel());
    }

    @Override
    public boolean existsById(final long id) {
        return diaryJpaRepository.existsById(id);
    }
}
