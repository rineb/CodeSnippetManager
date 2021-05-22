public class Main {
    public static void main(String[] args) {
        NoteCollection noteCollection = new NoteCollection();
        SearchField search = new SearchField(noteCollection);
        NoteList noteList = new NoteList(noteCollection);
        NoteForm noteForm = new NoteForm(noteCollection);
        NewButton newButton = new NewButton(noteCollection, noteList);
        SaveButton saveButton = new SaveButton(noteCollection, noteForm, noteList);

        new Frame(noteList,search, newButton, saveButton, noteForm);
    }
}
