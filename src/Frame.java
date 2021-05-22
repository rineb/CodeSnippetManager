import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private NoteList notes;
    private SearchField search;
    private NewButton newButton;
    private SaveButton saveButton;
    private NoteForm noteForm;

    public Frame(NoteList notes, SearchField search, NewButton newButton, SaveButton saveButton, NoteForm noteForm) {
        //Inicializimi i objekteve
        this.notes = notes;
        this.search = search;
        this.newButton = newButton;
        this.saveButton = saveButton;
        this.noteForm = noteForm;

        //Krijimi i Container
        Container cp = getContentPane();
        cp.setLayout(null);

        //Shtimi i listes me notes dhe shiritit vertikal
        JScrollPane listScrollPane = new JScrollPane(notes.getList());
        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //listScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        listScrollPane.setBounds(0, 40, 400, 740);
        cp.add(listScrollPane);

        //Shtimi i labels te titullit, pershkrimit, tagut dhe permbajtjes
        Font labelFont = new Font("Arial", Font.BOLD,20);
        JLabel title, description, tag, content;
        title = new JLabel("Title:");
        title.setBounds(450, 40, 140, 50);
        title.setFont(labelFont);
        description = new JLabel("Description:");
        description.setBounds(450, 80, 140, 50);
        description.setFont(labelFont);
        tag = new JLabel("Tag:");
        tag.setBounds(450, 120, 140, 50);
        tag.setFont(labelFont);
        content = new JLabel("Content:");
        content.setBounds(450, 160, 140, 50);
        content.setFont(labelFont);
        cp.add(title);
        cp.add(description);
        cp.add(tag);
        cp.add(content);

        //Krijimi i fushave te tekstit ku shenohet titulli, pershkrimi, tagu
        cp.add(noteForm.getTitleField());
        cp.add(noteForm.getDescriptionField());
        cp.add(noteForm.getTagField());

        //Shtimi i hapesires se shkruarjes se kodit dhe shiritit horizontal, vertikal
        JScrollPane contentScrollPane = new JScrollPane(noteForm.getContentArea());
        contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        contentScrollPane.setBounds(450, 210, 700, 450);
        cp.add(contentScrollPane);

        //Shtimi i butonit Save, New dhe fushes per kerkim
        cp.add(saveButton);
        cp.add(newButton);
        cp.add(search);

        //Detaje te kornizes
        setTitle("Code Snippet Manager");
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
