package pl.pkrysztofiak.theiadrawer.view.panel;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import pl.pkrysztofiak.theiadrawer.view.panel.image.ImagePanelView;
import pl.pkrysztofiak.theiadrawer.view.panel.image.tool.PanelToolHandler;
import pl.pkrysztofiak.theiadrawer.view.panel.toolbar.ToolbarView;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.PanelViewModel;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar.tool.Tool;

public class PanelView extends BorderPane {

    private final ToolbarView toolbarView;
    private final ImagePanelView imagePanelView;
    private final PanelToolHandler toolHandler;

    public final ObjectProperty<Tool> selectedToolProperty = new SimpleObjectProperty<>();
    
    {
        setStyle("-fx-background-color: purple, white; -fx-background-insets: 0, 1;");
    }
    
    public PanelView(PanelViewModel panelViewModel) {
        selectedToolProperty.bindBidirectional(panelViewModel.selectedToolProperty);
        
        toolbarView = new ToolbarView(panelViewModel.getToolbarViewModel());
        initToolbar();
        
        imagePanelView = new ImagePanelView(panelViewModel.getImagePanelViewModel());
        toolHandler = new PanelToolHandler(imagePanelView);
        toolHandler.selectedToolProperty.bindBidirectional(selectedToolProperty);

        setTop(toolbarView);
        setCenter(imagePanelView);
    }
    
    private void initToolbar() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/panel/toolbar/ToolbarView.fxml"));
        fxmlLoader.setRoot(toolbarView);
        fxmlLoader.setController(toolbarView);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}