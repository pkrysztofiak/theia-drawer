package pl.pkrysztofiak.theiadrawer.view.panel.image.tool;

import java.util.Optional;

import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.subjects.PublishSubject;
import javafx.scene.input.MouseEvent;
import pl.pkrysztofiak.theiadrawer.view.panel.image.ImagePanelView;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.image.ImagePanelViewModel;

public abstract class ToolHandler {

    private final PublishSubject<Optional<Void>> disposeRequest = PublishSubject.create();
    
    protected final ImagePanelView imagePanelView;
    protected final ImagePanelViewModel imagePanelViewModel;
    
    public ToolHandler(ImagePanelView imagePanelView, ImagePanelViewModel imagePanelViewModel) {
        this.imagePanelView = imagePanelView;
        this.imagePanelViewModel = imagePanelViewModel;
        JavaFxObservable.eventsOf(imagePanelView, MouseEvent.MOUSE_PRESSED).takeUntil(disposeRequest).subscribe(this::onMousePressed);
    }
    
    public final void dispose() {
        disposeRequest.onNext(Optional.empty());
    }
    
    protected void onMousePressed(MouseEvent event) {
        
    }
}