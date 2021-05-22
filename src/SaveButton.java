import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButton extends JButton {
    private NoteCollection noteCollection;
    private NoteForm noteForm;

    public SaveButton(NoteCollection noteCollection, NoteForm noteForm, NoteList noteList) {
        this.noteCollection = noteCollection;
        this.noteForm = noteForm;

        setBounds(850, 700, 100, 50);
        setFont(new Font("Arial", Font.BOLD,25));
        setText("Save");
        setBackground(Color.GREEN);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteCollection.updateOpenedNote(noteForm.getTitleField().getText(),
                        noteForm.getDescriptionField().getText(),
                        noteForm.getTagField().getText(), noteForm.getContentArea().getText());
                noteCollection.saveNote(noteCollection.getOpenedNote());
            }
        });
        repaint();
    }
}
