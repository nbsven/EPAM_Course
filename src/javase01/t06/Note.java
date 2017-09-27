package javase01.t06;


public class Note {
    private String note;

    public Note(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return note;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Note) {
            return note.equals(((Note) obj).getNote());
        }
        return false;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}
