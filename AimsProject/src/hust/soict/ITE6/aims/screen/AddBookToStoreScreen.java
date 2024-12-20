package hust.soict.ITE6.aims.screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.ITE6.aims.media.Book;
import hust.soict.ITE6.aims.store.Store;

public class AddBookToStoreScreen extends JDialog {
    private static final long serialVersionUID = 1L;
    private JFrame parentFrame;
	private Store store;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField priceField;
    private JTextArea authorsArea;

    public AddBookToStoreScreen(JFrame parent, Store store) {
        super(parent, "Add Book", true);
        this.store = store;
        this.parentFrame = parent;
        
        setLayout(new BorderLayout(10, 10));
        setSize(600, 400);
        setLocationRelativeTo(parent);

        /// Create and configure panel for form fields
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Title Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Title:"), gbc);
        titleField = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        formPanel.add(titleField, gbc);

     // Category Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Category:"), gbc);
        categoryField = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        formPanel.add(categoryField, gbc);

        // Price Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Price:"), gbc);
        priceField = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        formPanel.add(priceField, gbc);

        // Authors Field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        formPanel.add(new JLabel("Authors (comma-separated):"), gbc);
        authorsArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(authorsArea);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        formPanel.add(scrollPane, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitBook());
        buttonPanel.add(submitButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void submitBook() {
        // Validate input
        if (!validateInput()) return;

        // Create Book
        String title = titleField.getText();
        String category = categoryField.getText();
        float price = Float.parseFloat(priceField.getText());
        
        Book book = new Book(title, category, price);
        
        // Add authors
        String authorsText = authorsArea.getText();
        if (!authorsText.isEmpty()) {
            String[] authors = authorsText.split(",");
            for (String author : authors) {
                book.addAuthor(author.trim());
            }
        }
        
        // Add to store
        store.addMedia(book);
        
        // Show success message
        JOptionPane.showMessageDialog(this, 
            "Book added successfully!", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
        
     // Refresh the store screen
        if (parentFrame instanceof StoreScreen) {
            ((StoreScreen) parentFrame).refreshStoreScreen();
        }
        
        // Close dialog
        dispose();
    }

    private boolean validateInput() {
        // Check if fields are empty
        if (titleField.getText().isEmpty() || 
            categoryField.getText().isEmpty() || 
            priceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all fields", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate price
        try {
            Float.parseFloat(priceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Price must be a valid number", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

}
