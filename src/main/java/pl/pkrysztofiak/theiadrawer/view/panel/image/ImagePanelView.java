package pl.pkrysztofiak.theiadrawer.view.panel.image;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import pl.pkrysztofiak.theiadrawer.view.measurements.MeasurementView;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.image.ImagePanelViewModel;

public class ImagePanelView extends Pane {

    private final ImagePanelViewModel viewModel;
    
    private final ObservableList<MeasurementView> measurements = FXCollections.observableArrayList();
    private final Observable<MeasurementView> measurementAddedObservable = JavaFxObservable.additionsOf(measurements);
    
    public ImagePanelView(ImagePanelViewModel viewModel) {
        this.viewModel = viewModel;
        Bindings.bindContent(getChildren(), measurements);
        Bindings.bindContent(measurements, viewModel.measurements);
    }
}