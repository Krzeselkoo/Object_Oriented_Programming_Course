package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;
    private SimulationApp simulationApp;

    private final double CELL_WIDTH = 75.0d;
    private final double CELL_HEIGHT = 75.0d;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField moveList;

    @FXML
    private Label moveInformation;

    @FXML
    private GridPane mapGrid;

    private void drawMap(){
        Boundary boundary = worldMap.getCurrentBoundary();
        initializeGrid(boundary);
        drawObjects(boundary);
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() ->{
            if(!mapGrid.getChildren().isEmpty()) {
                clearGrid();
            }
            drawMap();
            moveInformation.setText(message);
        });
    }

    public void onSimulationStartClicked(){
        simulationApp.startSimulation(getMoves());
        infoLabel.setText("");
        moveInformation.setFont(new Font(36));
    }

    private void initializeGrid(Boundary boundary){

        Text basicText = new Text("y//x");
        GridPane.setHalignment(basicText, HPos.CENTER);
        mapGrid.add(basicText, 0, 0);

        Integer[] dimensions = getDimensions(boundary);
        int xDimension = dimensions[0];
        int yDimension = dimensions[1];

        for(int x = 0; x <= xDimension; x++){
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
            if(x < xDimension){
                Text text = new Text(Integer.toString(boundary.bottomLeft().getX() + x));
                GridPane.setHalignment(text, HPos.CENTER);
                mapGrid.add(text, x+1, 0);
            }
        }

        for(int y = 0; y <= yDimension; y++){
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
            if(y < yDimension){
                Text text = new Text(Integer.toString(boundary.topRight().getY() - y));
                GridPane.setHalignment(text, HPos.CENTER);
                mapGrid.add(text, 0, y+1);
            }
        }
    }

    private void drawObjects(Boundary boundary){

        List<WorldElement> elements = worldMap.getElements();
        for (WorldElement element : elements){
            if(element instanceof Animal || worldMap.objectAt(element.getPosition()) instanceof Grass){
                Text text = new Text(element.toString());
                GridPane.setHalignment(text, HPos.CENTER);
                mapGrid.add(text, element.getPosition().getX() - boundary.bottomLeft().getX() + 1, boundary.topRight().getY() - element.getPosition().getY() + 1);
            }
        }

    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    private Integer[] getDimensions(Boundary boundary){
        Integer[] dimensions = new Integer[2];

        dimensions[0] = boundary.topRight().getX() - boundary.bottomLeft().getX() + 1;
        dimensions[1] = boundary.topRight().getY() - boundary.bottomLeft().getY() + 1;

        return dimensions;
    }

    private String[] getMoves(){
        return moveList.getText().split(" ");
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void setSimulationApp(SimulationApp simulationApp){
        this.simulationApp = simulationApp;
    }



}
