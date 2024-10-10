package org.example.seminar1;

import java.util.List;

public interface DiaryRepository {
    void save(Diary diary);
    void patch(long id, String body);
    void delete(long id);
    void restore(long id);
    List<Diary> findAll();
}
