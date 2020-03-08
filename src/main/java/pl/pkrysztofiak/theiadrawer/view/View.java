package pl.pkrysztofiak.theiadrawer.view;

import java.util.stream.IntStream;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import pl.pkrysztofiak.theiadrawer.view.panel.PanelView;
import pl.pkrysztofiak.theiadrawer.viewmodel.ViewModel;

public class View extends GridPane {

    private final ObservableList<PanelView> panels = FXCollections.observableArrayList();
    
    {
        setHgap(4.);
        setVgap(4.);
        setPadding(new Insets(4.));
        Bindings.bindContent(getChildren(), panels);
    }
    
    public View(ViewModel viewModel) {
        IntStream.range(0, viewModel.getColumns()).mapToObj(this::createColumnConstraints).forEach(getColumnConstraints()::add);
        IntStream.range(0, viewModel.getRows()).mapToObj(this::createRowConstraints).forEach(getRowConstraints()::add);
        IntStream.range(0, viewModel.getRows()).forEach(rowIndex -> IntStream.range(0, viewModel.getColumns()).forEach(columnIndex -> {
            Observable.just(1)
            .subscribeOn(Schedulers.computation())
            .map(next -> new PanelView(viewModel.createPanelViewModel()))
            .observeOn(JavaFxScheduler.platform()).subscribe(panelView -> {
                panels.add(panelView);
                GridPane.setConstraints(panelView, columnIndex, rowIndex);
            });
        }));
    }
    
    private ColumnConstraints createColumnConstraints(int columnIndex) {
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.SOMETIMES);
        return columnConstraints;
    }
    
    private RowConstraints createRowConstraints(int rowIndex) {
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.SOMETIMES);
        return rowConstraints;
    }
}