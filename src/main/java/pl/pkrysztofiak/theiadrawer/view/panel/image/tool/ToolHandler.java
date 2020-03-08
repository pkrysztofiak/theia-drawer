package pl.pkrysztofiak.theiadrawer.view.panel.image.tool;

import java.util.Optional;

import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.subjects.PublishSubject;
import javafx.scene.input.MouseEvent;
import pl.pkrysztofiak.theiadrawer.view.panel.image.ImagePanelView;

public abstract class ToolHandler {

    private final PublishSubject<Optional<Void>> disposeRequest = PublishSubject.create();
    
    protected final ImagePanelView imagePanelView;
    
    public ToolHandler(ImagePanelView imagePanelView) {
        this.imagePanelView = imagePanelView;
        JavaFxObservable.eventsOf(imagePanelView, MouseEvent.MOUSE_PRESSED).takeUntil(disposeRequest).subscribe(this::onMousePressed);
    }
    
    public final void dispose() {
        disposeRequest.onNext(Optional.empty());
    }
    
    protected void onMousePressed(MouseEvent event) {
        
    }
}