package org.example.diary.service;

public class Diary {
    private Long id;
    private final String title;
    private final String content;
    private String createdAt;

    public Diary(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Diary(Long id, String title, String content, String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public long getId() {return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
