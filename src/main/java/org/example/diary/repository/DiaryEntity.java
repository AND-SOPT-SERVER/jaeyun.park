package org.example.diary.repository;

import jakarta.persistence.*;

@Entity
public class DiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public DiaryEntity() {
    }

    public DiaryEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {//디비에서 넘어온 후에 id는 not null이 보장되어 있는 상태여야 하니까 long으로 return 해라
        return this.id;
    }
}
