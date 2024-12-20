package hust.soict.ITE6.aims.screen;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;

import hust.soict.ITE6.aims.media.CompactDisc;
import hust.soict.ITE6.aims.media.Track;
import hust.soict.ITE6.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JDialog {
        private Store store;
        private JFrame parentFrame;
        private JTextField titleField;
        private JTextField categoryField;
        private JTextField priceField;
        private JTextField artistField;
        private DefaultListModel<String> trackListModel;
        private JList<String> trackList;
        private JTextField trackNameField;
        private JTextField trackLengthField;
        private CompactDisc currentCD;

        public AddCompactDiscToStoreScreen(JFrame parent, Store store) {
            super(parent, "Add Compact Disc", true);
            this.store = store;
            this.parentFrame = parent;
            
            // Use a more compact layout
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
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

            // Artist
            addLabel(gbc, 0, 3, "Artist:");
            artistField = createCenteredTextField();
            addComponent(gbc, 1, 3, artistField);

            // Tracks List
            addLabel(gbc, 0, 4, "Tracks:");
            trackListModel = new DefaultListModel<>();
            trackList = new JList<>(trackListModel);
            JScrollPane scrollPane = new JScrollPane(trackList);
            scrollPane.setPreferredSize(new Dimension(200, 100));
            addComponent(gbc, 1, 4, scrollPane);

            // Track Name
            addLabel(gbc, 0, 5, "Track Name:");
            trackNameField = createCenteredTextField();
            addComponent(gbc, 1, 5, trackNameField);

            // Track Length
            addLabel(gbc, 0, 6, "Track Length (seconds):");
            trackLengthField = createCenteredTextField();
            addComponent(gbc, 1, 6, trackLengthField);

            // Add Track Button
            JButton addTrackButton = createStyledButton("Add Track");
            addTrackButton.addActionListener(e -> addTrack());
            addComponent(gbc, 1, 7, addTrackButton);

            // Submit Button
            JButton submitButton = createStyledButton("Submit");
            submitButton.addActionListener(e -> submitCD());
            addComponent(gbc, 1, 8, submitButton);

            // Cancel Button
            JButton cancelButton = createStyledButton("Cancel");
            cancelButton.addActionListener(e -> dispose());
            addComponent(gbc, 1, 9, cancelButton);

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
            button.setPreferredSize(new Dimension(200, 30));
            return button;
        }

        // Helper method to add labels with centered text
        private void addLabel(GridBagConstraints gbc, int x, int y, String text) {
            gbc.gridx = x;
            gbc.gridy = y;
            JLabel label = new JLabel(text, SwingConstants.CENTER);
            add(label, gbc);
        }

        // Helper method to add components
        private void addComponent(GridBagConstraints gbc, int x, int y, JComponent component) {
            gbc.gridx = x;
            gbc.gridy = y;
            add(component, gbc);
        }

        // Rest of the methods remain the same as in the previous implementation
        private void addTrack() {
            String trackName = trackNameField.getText();
            String trackLengthStr = trackLengthField.getText();

            if (trackName.isEmpty() || trackLengthStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Please enter track name and length", 
                    "Track Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int trackLength = Integer.parseInt(trackLengthStr);
                Track track = new Track(trackName, trackLength);
                
                // If CD hasn't been created yet, create it first
                if (currentCD == null) {
                    currentCD = new CompactDisc(
                        titleField.getText(), 
                        categoryField.getText(), 
                        Float.parseFloat(priceField.getText()),
                        artistField.getText()
                    );
                }
                
                // Add track to the CD
                currentCD.addTrack(track);
                
                // Update the track list model with track name and length
                trackListModel.addElement(trackName + " (" + trackLength + " sec)");
                
                // Clear track input fields
                trackNameField.setText("");
                trackLengthField.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                    "Track length must be a number", 
                    "Track Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
  }
    

    private void submitCD() {
        // Validate input
        if (!validateInput()) return;

        // If CD hasn't been created yet (no tracks added), create it
        if (currentCD == null) {
        	currentCD = new CompactDisc(
                    titleField.getText(), 
                    categoryField.getText(), 
                    Float.parseFloat(priceField.getText()),
                    artistField.getText()
            );
        }

        // Add to store
        store.addMedia(currentCD);
        
        // Show success message
        JOptionPane.showMessageDialog(this, 
            "CD added successfully!", 
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
            priceField.getText().isEmpty() ||
            artistField.getText().isEmpty()) {
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
        
        // Check if tracks were added if needed
        if (currentCD == null && trackListModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please add at least one track or create the CD", 
                "Validation Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}