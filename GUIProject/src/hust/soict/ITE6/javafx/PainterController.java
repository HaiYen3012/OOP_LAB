package hust.soict.ITE6.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ToggleGroup;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton pen;
    
    @FXML
    private RadioButton eraser;
    
    @FXML
    private ToggleGroup toolsGroup;

    @FXML
    void initialize() {
        toolsGroup = new ToggleGroup();
        pen.setToggleGroup(toolsGroup);
        eraser.setToggleGroup(toolsGroup);
        pen.setSelected(true);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Rectangle clipArea = new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
        drawingAreaPane.setClip(clipArea);
        Color color;
        if (pen.isSelected()) {
            color = Color.BLACK;
        } else if (eraser.isSelected()) {
            color = Color.WHITE;
        } else {
            return;
        }
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    
}

