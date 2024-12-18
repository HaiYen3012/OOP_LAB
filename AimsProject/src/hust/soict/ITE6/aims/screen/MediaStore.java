package hust.soict.ITE6.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.ITE6.aims.media.*;

public class MediaStore extends JPanel {
    private Media media;

    private static final String ADD_TO_CART_BUTTON_TEXT = "Add to cart";
    private static final String PLAY_BUTTON_TEXT = "Play";
    private static final String ADDED_TO_CART_MESSAGE = " has been added";

    public MediaStore(Media media) {
        this.media = media;
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
                JOptionPane.showMessageDialog(MediaStore.this, 
                		media.getTitle() + ADDED_TO_CART_MESSAGE, 
                		"Add to cart", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        container.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton(PLAY_BUTTON_TEXT);
            playButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle(media.getTitle());
                    dialog.setSize(400, 300);

                    JLabel mediaLabel = new JLabel(media.playGUI());
                    mediaLabel.setVerticalAlignment(JLabel.CENTER);
                    mediaLabel.setHorizontalAlignment(JLabel.CENTER);

                    JScrollPane scrollPane = new JScrollPane(mediaLabel);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                    dialog.add(scrollPane);
                    dialog.setVisible(true);
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
