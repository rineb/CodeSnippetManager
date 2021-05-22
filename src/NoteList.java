import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class NoteList extends JPanel {
    private NoteCollection noteCollection;
    private JList<String> list;
    private DefaultListModel items;

    public NoteList(NoteCollection noteCollection) {
        this.noteCollection = noteCollection;
        items = new DefaultListModel<>();
        noteCollection.setNoteListPanel(this);
        list = new JList<>(items);

        list.setFixedCellHeight(740/10);
        list.setFixedCellWidth(400);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFont(new Font("Arial", Font.BOLD,25));

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                noteCollection.setOpenedNote(list.getSelectedIndex());
            }
        });
        refresh();
    }

    public void refresh() {
        items.clear();
        for (Note n : noteCollection.getListOfActiveNotes()) {
            items.addElement(n.getTitle());
        }
    }

    public void clearSelection() {
        list.clearSelection();
    }

    public JList<String> getList() {
        return list;
    }
}
