package org.example.diary.service;

import org.example.diary.api.DiaryCreateRequest;
import org.example.diary.api.DiaryResponse;
import org.example.diary.repository.DiaryEntity;
import org.example.diary.repository.DiaryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public void createDiary(DiaryCreateRequest request) {
        diaryRepository.save(new DiaryEntity(request.getName()));
    }

    public List<Diary> getList() {
        return diaryRepository.findAll().stream()
                .map(diaryEntity -> new Diary(diaryEntity.getId(), diaryEntity.getName())).toList();
    }

}
