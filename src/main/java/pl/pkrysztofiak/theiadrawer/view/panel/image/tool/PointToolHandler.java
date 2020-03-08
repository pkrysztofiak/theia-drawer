package pl.pkrysztofiak.theiadrawer.view.panel.image.tool;

import javafx.scene.input.MouseEvent;
import pl.pkrysztofiak.theiadrawer.view.panel.image.ImagePanelView;

public class PointToolHandler extends ToolHandler {

    public PointToolHandler(ImagePanelView imagePanelView) {
        super(imagePanelView);
    }

    @Override
    protected void onMousePressed(MouseEvent event) {
        System.out.println("PointToolHandler.onMousePressed");
    }
}