package org.example.seminar1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiaryService {
    private Map<MemoryType, DiaryRepository> diaryRepositoryMap;

    DiaryService (Map<MemoryType, DiaryRepository> diaryRepositoryMap) {
        this.diaryRepositoryMap = diaryRepositoryMap;
    }

    void writeDiary(final String body, final MemoryType memoryType) {
        final Diary diary = new Diary(null, body, false);
        getDiaryRepository(memoryType).save(diary);
    }용

    List<Diary> getDiaryList(final MemoryType memoryType) {
        return getDiaryRepository(memoryType).findAll();
    }

    void patchDiary(final long id, final String body, final MemoryType memoryType) {
        getDiaryRepository(memoryType).patch(id, body);
    }

    void deleteDiary(final long id, final MemoryType memoryType) {

        getDiaryRepository(memoryType).delete(id);
    }

    public void restoreDiary(long longId, final MemoryType memoryType) {
        getDiaryRepository(memoryType).restore(longId);
    }

    private DiaryRepository getDiaryRepository(MemoryType memoryType) {
        DiaryRepository repository = diaryRepositoryMap.get(memoryType);
        if (repository == null) {
            throw new IllegalArgumentException("해당 MemoryType에 맞는 Repository가 없습니다: " + memoryType);
        }
        return repository;
    }
}