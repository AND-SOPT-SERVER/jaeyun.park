package org.example.diary.service.response;

import org.example.diary.service.Diary;

public record DiaryResponse(long id, String title, String content, String createdAt) {
    public static DiaryResponse of (Diary diary) {
        return new DiaryResponse(diary.getId(), diary.getTitle(), diary.getContent(), diary.getCreatedAt());
    }
}
