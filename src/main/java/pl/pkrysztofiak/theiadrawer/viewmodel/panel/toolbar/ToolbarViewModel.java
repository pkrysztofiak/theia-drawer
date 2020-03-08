package pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.toolbar.tool.Tool;

public class ToolbarViewModel {

    public final ObjectProperty<Tool> selectedToolProperty = new SimpleObjectProperty<>();
    
    public void setTool(Tool tool) {
        System.out.println("setTool(" + tool + ")");
        selectedToolProperty.set(tool);
    }
}
