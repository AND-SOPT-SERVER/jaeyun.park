package org.example.seminar1;

import java.util.ArrayList;
import java.util.List;

public class DiaryController {

    private Status status = Status.READY;
    private final DiaryService diaryService = new DiaryService();

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
    final List<Diary> getList() {
        return diaryService.getDiaryList();
    }

    final void post(final String body) {
        if (body.length() > 30) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.writeDiary(body);
    }

    final void delete(final String id) {
        long longId = Long.parseLong(id);
        if (longId < 1) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.deleteDiary(longId);
    }

    final void patch(final String id, final String body) {
        long longId = Long.parseLong(id);
        if (longId < 1) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.patchDiary(longId, body);
    }

    final void restore(final String id) {
        long longId = Long.parseLong(id);
        if (longId < 1) {
            throw new Main.UI.InvalidInputException();
        }
        diaryService.restoreDiary(longId);
    }

    enum Status {
        READY,
        RUNNING,
        FINISHED,
        ERROR,
    }
}