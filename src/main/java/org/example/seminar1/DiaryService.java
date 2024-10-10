package org.example.seminar1;

import java.util.List;

public class DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepository();

    void writeDiary(final String body) {
        final Diary diary = new Diary(null, body, false);
        diaryRepository.save(diary);
    }

    List<Diary> getDiaryList() {
        return diaryRepository.findAll();
    }

    void patchDiary(final long id, final String body) {
        diaryRepository.patch(id, body);
    }

    void deleteDiary(final long id) {
        diaryRepository.delete(id);
    }

    public void restoreDiary(long longId) {
        diaryRepository.restore(longId);
    }
}