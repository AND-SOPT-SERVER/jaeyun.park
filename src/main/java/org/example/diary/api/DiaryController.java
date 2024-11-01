package org.example.diary.api;

import jakarta.validation.Valid;
import java.net.URI;
import org.example.diary.service.DiaryService;
import org.example.diary.service.response.DiaryListResponse;
import org.example.diary.service.response.DiaryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diaries")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping
    ResponseEntity<Void> post(@Valid @RequestBody final DiaryCreateRequest request) {
        return ResponseEntity.created(
                URI.create("/diaries/" + diaryService.createDiary(request.toDiary())))
                .build();
    }

    @GetMapping
    ResponseEntity<DiaryListResponse> getDiaryList() {
        return ResponseEntity.ok(diaryService.getList());
    }

    @GetMapping("/{id}")
    ResponseEntity<DiaryResponse> getDiary(@PathVariable final Long id) {
        return ResponseEntity.ok(diaryService.findById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDiary(@PathVariable final Long id) {
        diaryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<DiaryResponse> updateDiary(@PathVariable final Long id, @Valid @RequestBody final DiaryUpdateRequest request) {
        diaryService.updateDiary(id, request.toDiary());
        return ResponseEntity.ok(diaryService.findById(id));
    }
}
