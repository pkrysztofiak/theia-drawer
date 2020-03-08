package pl.pkrysztofiak.theiadrawer.view.panel.image.tool;

import java.util.Optional;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.sources.Change;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.pkrysztofiak.theiadrawer.view.panel.image.ImagePanelView;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar.tool.Tool;

public class PanelToolHandler {

    public final ObjectProperty<Tool> selectedToolProperty = new SimpleObjectProperty<>();
    private final Observable<Tool> selectedToolObservable = JavaFxObservable.valuesOf(selectedToolProperty);

    private final ObjectProperty<ToolHandler> toolHandlerPropery = new SimpleObjectProperty<>();
    private final Observable<Change<ToolHandler>> toolHandlerChangeObservable = JavaFxObservable.changesOf(toolHandlerPropery);
    
    private ImagePanelView imagePanelView;
    
    {
        selectedToolObservable.subscribe(this::onToolChanged);
        toolHandlerChangeObservable.subscribe(this::onToolHandlerChanged);
    }
    
    public PanelToolHandler(ImagePanelView imagePanelView) {
        this.imagePanelView = imagePanelView;
    }
    
    private void onToolChanged(Tool tool) {
        System.out.println("tool change=" + tool);
        switch (tool) {
        case POINT:
            toolHandlerPropery.set(new PointToolHandler(imagePanelView));
            break;
        case POLYGON:
            toolHandlerPropery.set(new PolygonToolHandler(imagePanelView));
            break;
        default:
            break;
        }
    }
    
    private void onToolHandlerChanged(Change<ToolHandler> change) {
        Optional.ofNullable(change.getOldVal()).ifPresent(ToolHandler::dispose);
    }
}