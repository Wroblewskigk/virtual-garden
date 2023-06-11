package vrgarden;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static vrgarden.Field.assignHostsPlants;
import static vrgarden.Field.resetWasUsed;

public class HelloController {

    @FXML
    private TextArea console;
    private PrintStream ps;

    public void initialize() {
        ps = new PrintStream(new Console(console)) ;
    }

    @FXML
    public GridPane gardenGrid;

    public List<Pane> paneArray = new ArrayList<>(100);

    /**
     * A method that adds all the program's panes to the grid pane
     * for later access
     *
     * @return ArrayList of Pane objects
     */
    public List<Pane> fillPaneArray() {
        String decades;
        String unity;
        String numberOfIndexString;
        int numberOfIndex;

        for(int i=0; i<HelloApplication.GARDEN_SIZE; i++) {
            decades = Integer.toString(i);

            for (int j = 0; j <HelloApplication.GARDEN_SIZE; j++) {
                unity = Integer.toString(j);
                numberOfIndexString = decades + unity;
                numberOfIndex = Integer.parseInt(numberOfIndexString);

                paneArray.add(numberOfIndex, (Pane) gardenGrid.getChildren().get(numberOfIndex));
                System.out.println(paneArray.get(numberOfIndex));
            }
        }
        return paneArray;
    }

    /**
     * @param ignoredEvent
     * Method that start the entire simulation. Think of it as replacement
     * for the 'main' method
     */
    public void button(ActionEvent ignoredEvent) {
        System.setOut(ps);
        System.setErr(ps);

        //Adds all panes to List<Node> paneArray
        List<Pane> paneArray = fillPaneArray();

        //Generate garden on button click
        Field[][] garden = GardenGenerator.GenerateGarden();

        //Generate entities
        Object[][] gardenEntities = EntityGenerator.GenerateEntity();

        //Render fields and entities onto gardenGrid GUI
        changePaneColorOnField(garden, paneArray);
        renderEntities(garden, paneArray);

        //Main simulation loop
        for (int i=0; i<HelloApplication.SIMULATION_CYCLES_AMOUNT; i++){

            resetWasUsed(garden);
            assignHostsPlants(garden, gardenEntities);
        }
    }

    public void changePaneColorOnField(Field[][] garden, List<Pane> paneArray){
        for (int i=0; i<HelloApplication.GARDEN_SIZE; i++){
            for (int j=0; j<HelloApplication.GARDEN_SIZE; j++){
                if(Objects.equals(garden[i][j].getFieldType(), "Grass")){
                    paneArray.get(i*10+j).setBackground(new Background(new BackgroundFill(
                            Color.web("#79d021"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                if(Objects.equals(garden[i][j].getFieldType(), "Sand")){
                    paneArray.get(i*10+j).setBackground(new Background(new BackgroundFill(
                            Color.web("#f6d7b0"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                if(Objects.equals(garden[i][j].getFieldType(), "Dirt")){
                    paneArray.get(i*10+j).setBackground(new Background(new BackgroundFill(
                            Color.web("#6b5428"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    public void renderEntities(Object[][] gardenEntities, List<Pane> paneArray) {
        for (int i = 0; i < HelloApplication.GARDEN_SIZE; i++) {
            for (int j = 0; j < HelloApplication.GARDEN_SIZE; j++) {
                if (Objects.equals(gardenEntities[i][j], "Cabbage")) {
                    paneArray.get(i * 10 + j).setBackground(new Background(new BackgroundFill(
                            Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                if (Objects.equals(gardenEntities[i][j], "Snail")) {
                    paneArray.get(i * 10 + j).setBackground(new Background(new BackgroundFill(
                            Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    public static class Console extends OutputStream {
        private final TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) {
            appendText(String.valueOf((char)b));
        }
    }
}
