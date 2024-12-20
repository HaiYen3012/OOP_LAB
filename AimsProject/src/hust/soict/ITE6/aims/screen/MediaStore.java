package hust.soict.ITE6.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.ITE6.aims.media.*;

import hust.soict.ITE6.aims.cart.CartLHY;
import hust.soict.ITE6.aims.media.*;

public class MediaStore extends JPanel {
    private static final String ADD_TO_CART_BUTTON_TEXT = "Add to cart";
    private static final String PLAY_BUTTON_TEXT = "Play";
    private static final String ADDED_TO_CART_MESSAGE = " has been added";
    
    private static final long serialVersionUID = 1L;
    private CartLHY cart; // Change this to be passed in constructor
    private Media media;
    
    public MediaStore(Media media, CartLHY cart) {
    	this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("%.2f$", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton(ADD_TO_CART_BUTTON_TEXT);
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String message = cart.addMedia(media);
                    JOptionPane.showMessageDialog(MediaStore.this, 
                            message, 
                            "Add to cart", 
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (LimitExceededException ex) {
                    JOptionPane.showMessageDialog(MediaStore.this, 
                            ex.getMessage(), 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(addToCartButton);


        // Play Button for Playable items (like DVD or CD)
        if (media instanceof Playable) {
            JButton playButton = new JButton(PLAY_BUTTON_TEXT);
            playButton.addActionListener(e -> showPlayDialog((Playable) media));
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    // Method to display Play information in a JDialog
    private void showPlayDialog(Playable playableMedia) {
        // Format the message for Playable items
        String playMessage = "Now Playing:\n" +
                             "Title: " + ((Media) playableMedia).getTitle() + "\n" +
                             "Length: " + ((Disc) playableMedia).getLength() + " minutes";

        // Display the message in a JDialog
        JDialog playDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Play Media", true);
        playDialog.setLayout(new BorderLayout());

     // Create a panel to hold the JTextArea with padding
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Text area for the message
        JTextArea messageArea = new JTextArea(playMessage);
        messageArea.setFont(new Font("Arial", Font.PLAIN, 16));
        messageArea.setEditable(false);
        messageArea.setWrapStyleWord(true);
        messageArea.setLineWrap(true);  // Enable word wrapping
        messageArea.setBackground(new Color(240, 240, 240));  // Light background for readability
        messageArea.setMargin(new Insets(10, 10, 10, 10));  // Add margin to prevent text from sticking to the edges
        panel.add(new JScrollPane(messageArea), BorderLayout.CENTER);

        playDialog.add(panel, BorderLayout.CENTER);

        // Close Button with better styling
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center the button
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(new Color(60, 179, 113)); // A pleasant green background
        closeButton.setForeground(Color.WHITE);  // White text
        closeButton.addActionListener(e -> playDialog.dispose());
        buttonPanel.add(closeButton);

        playDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Set the size and location of the dialog
        playDialog.setSize(400, 200);
        playDialog.setLocationRelativeTo(this);
        playDialog.setVisible(true);
    }
}
