package org.example.seminar1;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryDiaryRepository implements DiaryRepository {

    private final Map<Long, Diary> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    public List<Diary> findAll() {
        return storage.values().stream()
                .filter(diary -> !diary.getIsDeleted())
                .toList();
    }

    public void save(final Diary diary) {
        final long id = numbering.addAndGet(1);//1추가하고 추가한 값 return
        diary.setId(id);
        storage.put(id, diary);
    }

    public void patch(final long id, final String body) {
        Diary diary = storage.get(id);
        validateRetrieval(diary);
        diary.setBody(body);
        storage.put(diary.getId(), diary);
    }

    public void delete(long id) {
        Diary diary = storage.get(id);
        validateRetrieval(diary);
        diary.setIsDeleted(true);
        storage.put(diary.getId(), diary);
    }

    public void restore(long longId) {
        Diary diary = storage.get(longId);
        if (diary == null) {
            throw new IllegalArgumentException("해당 id를 가진 Diary가 없습니다.");
        }
        if (!diary.getIsDeleted()) {
            throw new IllegalStateException("해당 id를 가진 Diary는 삭제되지 않았습니다.");
        }
        diary.setIsDeleted(false);
        storage.put(diary.getId(), diary);
    }

    private static void validateRetrieval(Diary diary) {
        if (diary == null) {
            throw new IllegalArgumentException("해당 id를 가진 Diary가 없습니다.");
        }
        if (diary.getIsDeleted()) {
            throw new IllegalStateException("해당 id를 가진 Diary가 이미 삭제되었습니다.");
        }
    }
}