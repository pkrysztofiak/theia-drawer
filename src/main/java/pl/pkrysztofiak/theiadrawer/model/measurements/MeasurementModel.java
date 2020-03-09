package pl.pkrysztofiak.theiadrawer.model.measurements;

public abstract class MeasurementModel {

    public abstract Type getType(); 
    
    public enum Type {
        POINT, POLYGON
    }
}
