import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewButton extends JButton {
    private NoteCollection noteCollection;
    private NoteList noteList;

    public NewButton(NoteCollection noteCollection, NoteList noteList) {
        this.noteCollection = noteCollection;
        this.noteList = noteList;

        setBounds(650, 700, 100, 50);
        setFont(new Font("Arial", Font.BOLD,25));
        setText("New");
        setBackground(Color.YELLOW);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteCollection.openNewNote();
                noteList.clearSelection();
            }

        });
        repaint();
    }
}
