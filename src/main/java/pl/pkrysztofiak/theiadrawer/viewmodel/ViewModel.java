package pl.pkrysztofiak.theiadrawer.viewmodel;

import pl.pkrysztofiak.theiadrawer.model.Model;
import pl.pkrysztofiak.theiadrawer.viewmodel.panel.PanelViewModel;

public class ViewModel {

    private final Model model;
    
    private final int columns = 1;
    private final int rows = 3;
    
    public ViewModel(Model model) {
        this.model = model;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
    
    public PanelViewModel createPanelViewModel() {
        PanelViewModel panelViewModel = new PanelViewModel(model);
        return panelViewModel;
    }
}