package Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RandProductSearchGUI extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JTextArea searchResults;

    public RandProductSearchGUI() {
        setTitle("Product Search");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        searchField = new JTextField();
        topPanel.add(searchField, BorderLayout.CENTER);

        searchButton = new JButton("Search");
        topPanel.add(searchButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        searchResults = new JTextArea();
        searchResults.setEditable(false);
        add(new JScrollPane(searchResults), BorderLayout.CENTER);
    }

    public void setSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public String getSearch() {
        return searchField.getText();
    }

    public void setSearchResults(String results) {
        searchResults.setText(results);
    }
}
