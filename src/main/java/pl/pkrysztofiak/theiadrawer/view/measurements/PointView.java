package pl.pkrysztofiak.theiadrawer.view.measurements;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.pkrysztofiak.theiadrawer.viewmodel.measurements.PointViewModel;

public class PointView extends MeasurementView {

    private final ObjectProperty<Double> xProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<Double> yProperty = new SimpleObjectProperty<>();
    
    private final Circle circle = new Circle(8, Color.PURPLE);
    
    public PointView(double x, double y, PointViewModel viewModel) {
        xProperty.set(x);
        yProperty.set(y);
        viewModel.xProperty.bindBidirectional(xProperty);
        viewModel.yProperty.bindBidirectional(yProperty);
    }
}