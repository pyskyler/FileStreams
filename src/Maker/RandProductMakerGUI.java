package Maker;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RandProductMakerGUI extends JFrame {

    private JTextField nameField;
    private JTextField priceField;
    private JTextField idField;
    private JTextArea descriptionArea;
    private JButton submitButton;

    public RandProductMakerGUI() {
        // Initialize GUI components
    }

    public void setSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getPrice() {
        return priceField.getText();
    }

    public String getId() {
        return idField.getText();
    }

    public String getDescription() {
        return descriptionArea.getText();
    }

    public void clearFields() {
        nameField.setText("");
        priceField.setText("");
        idField.setText("");
        descriptionArea.setText("");
    }



}
