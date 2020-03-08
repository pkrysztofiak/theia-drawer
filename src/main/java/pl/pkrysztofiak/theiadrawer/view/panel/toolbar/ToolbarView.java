package pl.pkrysztofiak.theiadrawer.view.panel.toolbar;

import java.net.URL;
import java.util.ResourceBundle;

import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar.ToolbarViewModel;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar.tool.Tool;

public class ToolbarView extends FlowPane implements Initializable {
    
    @FXML
    private ToggleButton pointToolButton;
    
    @FXML
    private ToggleButton polygonToolButton;
    
    private final ToolbarViewModel viewModel;
    
    public ToolbarView(ToolbarViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JavaFxObservable.valuesOf(pointToolButton.selectedProperty()).filter(Boolean.TRUE::equals).map(selected -> Tool.POINT).subscribe(viewModel::setTool);
        JavaFxObservable.valuesOf(polygonToolButton.selectedProperty()).filter(Boolean.TRUE::equals).map(selected -> Tool.POLYGON).subscribe(viewModel::setTool);
    }
}