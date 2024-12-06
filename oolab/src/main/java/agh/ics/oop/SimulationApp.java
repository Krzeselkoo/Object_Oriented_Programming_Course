package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SimulationApp extends Application {
    private SimulationPresenter presenter;
    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }

    public void startSimulation(){
        try {
            GrassField map = new GrassField(4);
            //RectangularMap map = new RectangularMap(5,5);
            presenter.setWorldMap(map);
            map.subscribe(presenter);

            String[] movesArray = presenter.getMoves();

            List<MoveDirection> directions = OptionsParser.parse(movesArray);
            List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(0, 1));

            Simulation simulation = new Simulation(positions, directions, map);
            SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));

            simulationEngine.runAsync();

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        this.presenter = loader.getController();
        presenter.setSimulationApp(this);

        configureStage(primaryStage, viewRoot);
    }
}
