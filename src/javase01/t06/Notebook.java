package javase01.t06;

import java.util.ArrayList;

/**
 * Класс имитирующий блокнот, который содержит записи. Позволяет добавлять,
 * удалять и редактировать записи, а так же просматривать все записи.
 */
public class Notebook {
    /**
     * Массив записей в блокноте
     */
    private ArrayList<Note> notes = new ArrayList<>(100);

    /**
     * Метод для добавления новой записи в блокнот в виде {@code note}
     *
     * @param note новвая запись в виде {@code note}
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Метод для добавления записи в виде {@code String}
     *
     * @param s новая записиь в виде {@code String}
     */
    public void addNote(String s) {
        addNote(new Note(s));
    }

    /**
     * Удаление записи по самой записи
     *
     * @param note записиь эквивалентная которой будет удалена из блокнота
     */
    public void deleteNote(Note note) {
        notes.remove(note);
    }

    /**
     * Удаление записи по индексу
     *
     * @param i индекс удаляемой записи из блокнота
     */
    public void deleteNote(int i) {
        notes.remove(i);
    }

    /**
     * Редактирование записи, путем замены содержимого на новое
     *
     * @param index индекс записи, содержимое которой изменяется
     * @param note  новое содержимое записи в виде {@code Note}
     */
    public void editNote(int index, Note note) {
        notes.set(index, note);
    }

    /**
     * Редактирование записи, путем замены содержимого на новое
     *
     * @param index индекс записи, содержимое которой изменяется
     * @param s     новое содержимое записи в виде {@code String}
     */
    public void editNote(int index, String s) {
        notes.set(index, new Note(s));
    }

    /**
     * Метод для отображение всех записей блокнота построчно вместе с их индексами
     */
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
