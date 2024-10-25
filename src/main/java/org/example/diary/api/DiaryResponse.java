package org.example.diary.api;

public class DiaryResponse {
    private final long id;
    private final String name;

    public DiaryResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}