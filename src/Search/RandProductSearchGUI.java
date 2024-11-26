package Search;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RandProductSearchGUI extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JTextArea searchResults;

    public RandProductSearchGUI() {
        // Initialize GUI components
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
