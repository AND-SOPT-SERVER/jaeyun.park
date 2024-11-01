package org.example.diary.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.diary.service.Diary;

public record DiaryCreateRequest(@NotBlank String title,@NotBlank @Size(max = 30, message = "글자수 제한 확인")String content) {
    Diary toDiary() {
        return new Diary(title, content);
    }
}
