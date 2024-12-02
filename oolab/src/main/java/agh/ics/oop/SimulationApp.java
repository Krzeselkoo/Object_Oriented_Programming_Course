package agh.ics.oop;

import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.IncorrectPositionException;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SimulationApp extends Application {

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();

        configureStage(primaryStage, viewRoot);
        try {
            List<String> parameters = getParameters().getRaw();
            String[] parametersArray = parameters.toArray(new String[parameters.size()]);

            List<MoveDirection> directions = OptionsParser.parse(parametersArray);
            List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(0, 1), new Vector2d(0, 2), new Vector2d(0, 1));

            GrassField grassField = new GrassField(4);
            presenter.setWorldMap(grassField);
            grassField.subscribe(presenter);
            Simulation simulation = new Simulation(positions, directions, grassField);

            simulation.run();

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
