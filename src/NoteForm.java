import javax.swing.*;
import java.awt.*;

public class NoteForm extends JPanel {
    private NoteInfoField titleField;
    private NoteInfoField descriptionField;
    private NoteInfoField tagField;
    private JTextArea contentArea;
    private NoteCollection noteCollection;

    public NoteForm(NoteCollection noteCollection) {
        this.noteCollection = noteCollection;
        noteCollection.setNoteFormPanel(this);
        titleField = new NoteInfoField();
        titleField.setBounds(600, 50, 540, 30);
        descriptionField = new NoteInfoField();
        descriptionField.setBounds(600, 90, 540, 30);
        tagField = new NoteInfoField();
        tagField.setBounds(600, 130, 540, 30);
        contentArea = new JTextArea();
        contentArea.setFont(new Font("Arial", Font.PLAIN,20));
        noteCollection.openNewNote();
    }


    public NoteInfoField getTitleField() {
        return titleField;
    }

    public NoteInfoField getDescriptionField() {
        return descriptionField;
    }

    public NoteInfoField getTagField() {
        return tagField;
    }

    public JTextArea getContentArea() {
        return contentArea;
    }

    public void refresh() {
        Note n = noteCollection.getOpenedNote();
        titleField.setText(n.getTitle());
        descriptionField.setText(n.getDescription());
        tagField.setText(n.getTag());
        contentArea.setText(n.getContent());
    }
}
