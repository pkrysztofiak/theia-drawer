package pl.pkrysztofiak.theiadrawer.commons.geometry;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Point2D {

    private final ObjectProperty<Double> xProperty = new SimpleObjectProperty<>();
    private final Observable<Double> xObservable = JavaFxObservable.valuesOf(xProperty);
    
    private final ObjectProperty<Double> yProperty = new SimpleObjectProperty<>();
    private final Observable<Double> yObservable = JavaFxObservable.valuesOf(yProperty);
    
    public Point2D(double x, double y) {
        xProperty.set(x);
        yProperty.set(y);
    }
    
    public Observable<Double> xObservable() {
        return xObservable;
    }
    
    public Observable<Double> yObservable() {
        return yObservable;
    }
}
