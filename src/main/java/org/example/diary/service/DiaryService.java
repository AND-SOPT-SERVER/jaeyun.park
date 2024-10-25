package org.example.diary.service;

import org.example.diary.service.response.DiaryListResponse;
import org.example.diary.service.response.DiaryResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DiaryService {

    private final DiaryPersistence diaryPersistence;

    public DiaryService(DiaryPersistence diaryPersistence) {
        this.diaryPersistence = diaryPersistence;
    }

    public long createDiary(final Diary diary) {
        return diaryPersistence.save(diary).getId();
    }

    public DiaryListResponse getList() {
        return new DiaryListResponse(diaryPersistence.findAll().stream().map(DiaryResponse::of).toList());

    }

    public DiaryResponse findById(final long id) {
        return DiaryResponse.of(diaryPersistence.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("다이어리 존재하지 않습니다.")));
    }

    @Transactional
    public void deleteById(final long id) {
        validateExistence(id);
        diaryPersistence.deleteById(id);
    }

    @Transactional
    public DiaryResponse updateDiary(final Long id, final Diary diary) {
        //jpa entity찾아서 entityupdate후 model로 변환
        Diary updatedDiary = diaryPersistence.update(id, diary)
                .orElseThrow(() -> new IllegalArgumentException("다이어리가 존재하지 않습니다."));
        return DiaryResponse.of(updatedDiary);
    }

    private void validateExistence(Long id) {
        if (!diaryPersistence.existsById(id)) {
        throw new IllegalArgumentException("다이어리가 존재하지 않습니다.");
        }
    }
}
