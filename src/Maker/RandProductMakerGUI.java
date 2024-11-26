package Maker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RandProductMakerGUI extends JFrame {

    private JTextField nameField;
    private JTextField priceField;
    private JTextField idField;
    private JTextArea descriptionArea;
    private JButton submitButton;
    private JLabel productCountLabel;

    public RandProductMakerGUI() {
        setTitle("Product Maker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        // Name
        nameField = new JTextField(20);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        // Description
        descriptionArea = new JTextArea(5, 20);
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(descriptionLabel);
        inputPanel.add(new JScrollPane(descriptionArea));
        // ID
        idField = new JTextField(20);
        JLabel idLabel = new JLabel("ID:");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        // Price
        priceField = new JTextField(20);
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);

        mainPanel.add(inputPanel);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);

        mainPanel.add(buttonPanel);

        // Create product count label
        productCountLabel = new JLabel("Product Count: 0");
        productCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(productCountLabel);

        add(mainPanel);
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

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void setProductCount(int count) {
        productCountLabel.setText("Product Count: " + count);
    }



}
