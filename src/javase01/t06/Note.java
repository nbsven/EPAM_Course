package javase01.t06;

/**
 * Класс представляющий запись в блокноте в виде строки
 */
public class Note {
    /**
     * Строка хранящая запись
     */
    private String note;


    /**
     * Публичный конструктор, который инициализирует строку
     *
     * @param note Строка, являющаяся записью
     */
    public Note(String note) {
        this.note = note;
    }

    /**
     * Возвращает запись в виде строки
     *
     * @return Строковое представление записи
     */
    @Override
    public String toString() {
        return note;
    }

    /**
     * Проверяет на равенство двух записей
     *
     * @param obj Объект с которым сравнивается запись
     * @return true, если записи эквивалентны, false, в обратном случае
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Note && note.equals(((Note) obj).getNote());
    }

    /**
     * Метод устанавливающий записи новое содержимое
     *
     * @param note Новое содержимое
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Метод для получение содержимого записи в виде строки
     *
     * @return содержимое записи
     */
    public String getNote() {
        return note;
    }
}
