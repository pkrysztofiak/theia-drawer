package pl.pkrysztofiak.theiadrawer.view.panel.image.tool;

import javafx.scene.input.MouseEvent;
import pl.pkrysztofiak.theiadrawer.view.panel.image.ImagePanelView;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.image.ImagePanelViewModel;

public class PolygonToolHandler extends ToolHandler {

    public PolygonToolHandler(ImagePanelView imagePanelView, ImagePanelViewModel imagePanelViewModel) {
        super(imagePanelView, imagePanelViewModel);
    }

    @Override
    protected void onMousePressed(MouseEvent event) {
        System.out.println("PolygonToolHandler.onMousePressed()");
    }
}