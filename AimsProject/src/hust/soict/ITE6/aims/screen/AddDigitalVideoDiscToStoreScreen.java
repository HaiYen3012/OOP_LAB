package hust.soict.ITE6.aims.screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.ITE6.aims.media.DigitalVideoDiscLHY;
import hust.soict.ITE6.aims.store.Store;


public class AddDigitalVideoDiscToStoreScreen extends JDialog {
    private JFrame parentFrame;
    private Store store;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField priceField;
    private JTextField directorField;
    private JTextField lengthField;

    public AddDigitalVideoDiscToStoreScreen(JFrame parent, Store store) {
        super(parent, "Add Digital Video Disc", true);
        this.store = store;
        this.parentFrame = parent;
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        addLabel(gbc, 0, 0, "Title:");
        titleField = createCenteredTextField();
        addComponent(gbc, 1, 0, titleField);

        // Category
        addLabel(gbc, 0, 1, "Category:");
        categoryField = createCenteredTextField();
        addComponent(gbc, 1, 1, categoryField);

        // Price
        addLabel(gbc, 0, 2, "Price:");
        priceField = createCenteredTextField();
        addComponent(gbc, 1, 2, priceField);

        // Director
        addLabel(gbc, 0, 3, "Director:");
        directorField = createCenteredTextField();
        addComponent(gbc, 1, 3, directorField);

        // Length
        addLabel(gbc, 0, 4, "Length (minutes):");
        lengthField = createCenteredTextField();
        addComponent(gbc, 1, 4, lengthField);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton submitButton = createStyledButton("Submit");
        submitButton.addActionListener(e -> submitDVD());
        buttonPanel.add(submitButton);

        JButton cancelButton = createStyledButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    // Helper method to create centered text fields
    private JTextField createCenteredTextField() {
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setPreferredSize(new Dimension(200, 25));
        return textField;
    }

    // Helper method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 30));
        return button;
    }

    // Helper method to add labels with centered text
    private void addLabel(GridBagConstraints gbc, int x, int y, String text) {
        gbc.gridx = x;
        gbc.gridy = y;
        JLabel label = new JLabel(text, SwingConstants.LEFT);
        add(label, gbc);
    }

    // Helper method to add components
    private void addComponent(GridBagConstraints gbc, int x, int y, JComponent component) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }

    private void submitDVD() {
        // Validate input
        if (!validateInput()) return;

        try {
            // Create DVD
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(priceField.getText());
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());

            DigitalVideoDiscLHY dvd = new DigitalVideoDiscLHY(
            		title, category, cost, director, length
            );

            // Add to store
            store.addMedia(dvd);
            
            // Show success message
            JOptionPane.showMessageDialog(this, 
                "DVD added successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            
         // Refresh the store screen
            if (parentFrame instanceof StoreScreen) {
                ((StoreScreen) parentFrame).refreshStoreScreen();
            }
            
            // Close dialog
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Length must be a valid number", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateInput() {
        // Check if fields are empty
        if (titleField.getText().isEmpty() || 
            categoryField.getText().isEmpty() || 
            priceField.getText().isEmpty() ||
            directorField.getText().isEmpty() ||
            lengthField.getText().isEmpty()) {
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