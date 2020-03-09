package pl.pkrysztofiak.theiadrawer.viewmodel.panel.image;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pkrysztofiak.theiadrawer.model.Model;
import pl.pkrysztofiak.theiadrawer.model.measurements.MeasurementModel;
import pl.pkrysztofiak.theiadrawer.model.measurements.PointModel;
import pl.pkrysztofiak.theiadrawer.viewmodel.measurements.MeasurementViewModel;
import pl.pkrysztofiak.theiadrawer.viewmodel.measurements.PointViewModel;

public class ImagePanelViewModel {
    
    public final ObservableList<MeasurementViewModel> measurements = FXCollections.observableArrayList();
    private final ObservableList<MeasurementViewModel> sourceMeasurements = FXCollections.observableArrayList();
    private final Observable<MeasurementViewModel> sourceMeasurementAddedObservable = JavaFxObservable.additionsOf(sourceMeasurements);
     
    private final Model model;
    
    {
        sourceMeasurementAddedObservable.subscribe(measurements::add);
    }
    
    public ImagePanelViewModel(Model model) {
        this.model = model;
        
        model.measurementAddedObservable.observeOn(JavaFxScheduler.platform()).subscribe(this::onMeasurementModelAdded);
    }

    public void addPoint(double x, double y) {
        PointModel pointModel = new PointModel(x, y);
        PointViewModel pointViewModel = new PointViewModel(pointModel);
        sourceMeasurements.add(pointViewModel);
    }
    
    private void onMeasurementModelAdded(MeasurementModel measurementModel) {
        
        
        boolean isSource = sourceMeasurements.stream().anyMatch(viewModel -> viewModel.contains(measurementModel));
        
    }
}