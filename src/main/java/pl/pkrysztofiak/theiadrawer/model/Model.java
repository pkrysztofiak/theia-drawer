package pl.pkrysztofiak.theiadrawer.model;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pkrysztofiak.theiadrawer.model.measurements.MeasurementModel;

public class Model {

    public PublishSubject<MeasurementModel> addMeasurementRequest = PublishSubject.create();
    
    private final ObservableList<MeasurementModel> measurements = FXCollections.observableArrayList();
    public final Observable<MeasurementModel> measurementAddedObservable = JavaFxObservable.additionsOf(measurements).startWith(measurements);
    
    {
        addMeasurementRequest.delay(0, TimeUnit.SECONDS, Schedulers.single()).subscribe(this::onAddMeasurementRequest);
    }
    
    public Model() {
        
    }
    
    private void onAddMeasurementRequest(MeasurementModel measurement) {
        measurements.add(measurement);
    }
}
