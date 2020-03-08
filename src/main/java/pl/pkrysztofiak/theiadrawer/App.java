package pl.pkrysztofiak.theiadrawer;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pl.pkrysztofiak.theiadrawer.model.Model;
import pl.pkrysztofiak.theiadrawer.view.View;
import pl.pkrysztofiak.theiadrawer.viewmodel.ViewModel;

public class App extends Application {
    
    private final Model model = new Model();
    private final ViewModel viewModel = new ViewModel(model);
    private final View view = new View(viewModel);
    private final Scene scene = new Scene(view);
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(scene);
        
        double margin = 96;
        
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        stage.setX(bounds.getMinX() + margin);
        stage.setY(bounds.getMinY() + margin);
        stage.setWidth(bounds.getWidth() - 2 * margin);
        stage.setHeight(bounds.getHeight() - 2 * margin);
        stage.setMaximized(true);
        
        stage.show();
    }
}
