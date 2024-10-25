package org.example.diary.service;

import java.util.List;
import java.util.Optional;

public interface DiaryPersistence {
    public Diary save(final Diary diary);
    public Optional<Diary> findById(final long id);
    public void deleteById(final long id);
    public List<Diary> findAll();
    public Optional<Diary> update(final long id, final Diary diary);
    public boolean existsById(final long id);
}
