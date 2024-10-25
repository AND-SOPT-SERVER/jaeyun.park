package org.example.diary.api;

import org.example.diary.service.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/diaries")
    void post(@RequestBody DiaryCreateRequest request) {
        diaryService.createDiary(request);
    }

    @GetMapping("/diaries")
    ResponseEntity<DiaryListResponse> get() {
        return ResponseEntity.ok(
                new DiaryListResponse(diaryService.getList().stream()
                        .map(diary -> new DiaryResponse(diary.getId(), diary.getName())).toList())
        );
    }
}
