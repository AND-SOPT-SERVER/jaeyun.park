package org.example.diary.service.response;

import java.util.List;

public class DiaryListResponse {
    private List<DiaryResponse> diaryList;

    public DiaryListResponse(List<DiaryResponse> diaryList) {
        this.diaryList = diaryList;
    }

    public List<DiaryResponse> getDiaryList() {
        return diaryList;
    }
}
