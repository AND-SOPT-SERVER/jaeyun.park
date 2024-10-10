package org.example.seminar1;

import java.util.List;

public class DiaryController {

    private Status status = Status.READY;
    private final DiaryService diaryService;

    DiaryController (DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    Status getStatus() {
        return status;
    }

    void boot() {
        this.status = Status.RUNNING;
    }

    void finish() {
        this.status = Status.FINISHED;
    }

    // APIS
    final List<Diary> getList(final MemoryType memoryType) {
        return diaryService.getDiaryList(memoryType);
    }

    final void post(final String body, final MemoryType memoryType) {
        if (body.length() > 30) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.writeDiary(body, memoryType);
    }

    final void delete(final String id, final MemoryType memoryType) {
        long longId = Long.parseLong(id);
        if (longId < 1) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.deleteDiary(longId, memoryType);
    }

    final void patch(final String id, final String body, final MemoryType memoryType) {
        long longId = Long.parseLong(id);
        if (longId < 1) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.patchDiary(longId, body, memoryType);
    }

    final void restore(final String id, final MemoryType memoryType) {
        long longId = Long.parseLong(id);
        if (longId < 1) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.restoreDiary(longId, memoryType);
    }

    enum Status {
        READY,
        RUNNING,
        FINISHED,
        ERROR,
    }
}