import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchField extends JTextField {
    private NoteCollection noteCollection;

    public SearchField(NoteCollection noteCollection) {
        this.noteCollection = noteCollection;
        setBounds(0, 0, 400, 40);
        setFont(new Font("Arial", Font.PLAIN,20));

        /*Metoda addFocusListener mundeson qe kur klikohet jashte fushes se tekstit per kerkim te shfaqet
        nje placeholder (hint) me fjalen "Search" ndersa kur klikohet ne te, ajo zhduket*/
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals("Search...")) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(Color.GRAY);
                    setText("Search...");
                }
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                noteCollection.setSearch(getText());
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}
        });

        repaint();
    }
}
