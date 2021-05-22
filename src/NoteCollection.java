import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NoteCollection {
    private List<Note> listOfNotes;
    private List<Note> listOfActiveNotes;
    private NoteList noteListPanel;
    private NoteForm noteFormPanel;
    private Note openedNote;

    public NoteCollection() {
        listOfNotes = new ArrayList<>();
        listOfActiveNotes = new ArrayList<>();
        File directoryPath = new File("Notes");
        //List of all files and directories
        String[] paths = directoryPath.list();
        for (String path : paths) {
            Note note = readNote("Notes/" + path);
            listOfNotes.add(note);
            listOfActiveNotes.add(note);
        }
    }

    public void saveNote(Note note) {
        String noteDetails = note.getTitle() + System.lineSeparator()
                + note.getDescription() + System.lineSeparator() + note.getTag()
                + System.lineSeparator() + note.getContent() ;
        writeFileBytes("Notes/" + note.getTitle() + ".txt", noteDetails);

        if (!listOfNotes.contains(note)) {
            listOfNotes.add(0, note);
            listOfActiveNotes.add(0, note);
            noteListPanel.refresh();
        }
    }

    public Note readNote(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String title = br.readLine();
            String description = br.readLine();
            String tag = br.readLine();
            String content = br.readLine();
            String nextLine = br.readLine();
            while (nextLine != null) {
                content += System.lineSeparator() + nextLine;
                nextLine = br.readLine();
            }
            Note note = new Note(title, description, tag, content);
            return note;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private void writeFileBytes(String filePath, String str) {
        Path path = Paths.get(filePath);
        try {
            byte[] strToBytes = str.getBytes();
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setSearch(String searchText) {
        listOfActiveNotes.clear();
        searchText = searchText.toLowerCase().trim();
        for (Note n : listOfNotes) {
            if (searchText.startsWith("tag:")) {
                if (n.getTag().toLowerCase().startsWith(searchText.substring(4).trim())) {
                    listOfActiveNotes.add(n);
                }
            }
            if (n.getTitle().toLowerCase().startsWith(searchText)) {
                listOfActiveNotes.add(n);
            }
        }
        if (noteListPanel != null) {
            noteListPanel.refresh();
        }
    }

    public void setOpenedNote(int index) {
        if (index < 0) {
            return;
        }
        openedNote = listOfActiveNotes.get(index);
        noteFormPanel.refresh();
    }

    public void setNoteListPanel(NoteList noteListPanel) {
        this.noteListPanel = noteListPanel;
    }

    public void setNoteFormPanel(NoteForm noteFormPanel) {
        this.noteFormPanel = noteFormPanel;
    }

    public List<Note> getListOfActiveNotes() {
        return listOfActiveNotes;
    }

    public Note getOpenedNote() {
        return openedNote;
    }

    public void openNewNote() {
        openedNote = new Note("", "", "", "");
        noteFormPanel.refresh();
    }

    public void updateOpenedNote(String title, String description, String tag, String content) {
        openedNote.setTitle(title);
        openedNote.setDescription(description);
        openedNote.setTag(tag);
        openedNote.setContent(content);
    }
}
