package pl.pkrysztofiak.theiadrawer.viewmodel.panel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.pkrysztofiak.theiadrawer.model.Model;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.image.ImagePanelViewModel;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar.ToolbarViewModel;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar.tool.Tool;

public class PanelViewModel {

    private final Model model;
    private final ToolbarViewModel toolbarViewModel;
    private final ImagePanelViewModel imagePanelViewModel;
    
    public final ObjectProperty<Tool> selectedToolProperty = new SimpleObjectProperty<>();
    
    public PanelViewModel(Model model) {
        this.model = model;
        toolbarViewModel = new ToolbarViewModel();
        selectedToolProperty.bindBidirectional(toolbarViewModel.selectedToolProperty);
        
        imagePanelViewModel = new ImagePanelViewModel(model);
    }
    
    public ToolbarViewModel getToolbarViewModel() {
        return toolbarViewModel;
    }
    
    public ImagePanelViewModel getImagePanelViewModel() {
        return imagePanelViewModel;
    }
}