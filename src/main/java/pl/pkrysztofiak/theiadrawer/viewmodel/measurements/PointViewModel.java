package pl.pkrysztofiak.theiadrawer.viewmodel.measurements;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.pkrysztofiak.theiadrawer.model.measurements.MeasurementModel;
import pl.pkrysztofiak.theiadrawer.model.measurements.PointModel;

public class PointViewModel extends MeasurementViewModel {

    private final PointModel pointModel;
    
    public final ObjectProperty<Double> xProperty = new SimpleObjectProperty<>();
    public final ObjectProperty<Double> yProperty = new SimpleObjectProperty<>();

    
    public PointViewModel(PointModel pointModel) {
        this.pointModel = pointModel;
    }


    @Override
    public boolean contains(MeasurementModel measurementModel) {
        return measurementModel.equals(pointModel);
    }
}
