package pl.pkrysztofiak.theiadrawer.model.measurements;

import pl.pkrysztofiak.theiadrawer.commons.geometry.Point2D;

public class PointModel extends MeasurementModel {

    private final Point2D point;
    
    public PointModel(double x, double y) {
        point = new Point2D(x, y);
    }

    @Override
    public Type getType() {
        return MeasurementModel.Type.POINT;
    }
}