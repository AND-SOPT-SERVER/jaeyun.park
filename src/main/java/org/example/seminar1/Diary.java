package org.example.seminar1;

public class Diary {

    private Long id;
    private String body;
    private boolean isDeleted;

    Diary(Long id, String body, boolean isDeleted) {
        this.id = id;
        this.body = body;
        this.isDeleted = isDeleted;
    }

    Long getId() {
        return id;
    }

    String getBody() {
        return body;
    }

    boolean getIsDeleted() {
        return isDeleted;
    }

    void setId(Long id) {
        this.id = id;
    }

    void setBody(String body) {
        this.body = body;
    }

    void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
