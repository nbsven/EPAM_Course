package javase01.t06;

import java.util.ArrayList;
import java.util.Collections;

public class Notebook {
    private ArrayList<Note> notes = new ArrayList<>(100);

    public void addNote(Note note) {
        notes.add(note);
    }

    public void addNote(String s) {
        addNote(new Note(s));
    }

    public void deleteNote(Note note) {
        notes.remove(note);
    }

    public void deleteNote(int i) {
        notes.remove(i);
    }

    public void editNote(int index, Note note) {
        notes.set(index, note);
    }

    public void editNote(int index, String s) {
        notes.set(index, new Note(s));
    }

    public void showNotes() {
        if (notes.size() == 0) {
            System.out.println("Have no notes");
            System.out.println();
            return;
        }

        for (int i = 0; i < notes.size(); i++) {
            System.out.println("note " + i + ": " + notes.get(i));
        }
        System.out.println();
    }

}
