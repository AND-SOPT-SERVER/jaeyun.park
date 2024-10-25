package org.example.diary.api;

public class DiaryCreateRequest {
    private String name;


    public DiaryCreateRequest() {
    }
    public DiaryCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
