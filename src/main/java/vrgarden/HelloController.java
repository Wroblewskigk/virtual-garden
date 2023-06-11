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

/**
 * Class that holds main() method and all the logic for the controllers such as: buttons, textAreas ect.
 */
public class HelloController {

    @FXML
    private TextArea console;
    private PrintStream ps;

    /**
     * Method that initializes Console object
     */
    public void initialize() {
        ps = new PrintStream(new Console(console)) ;
    }

    @FXML
    public GridPane gardenGrid;

    /**
     * Array that holds all Panes that are inside the GridPane gardenGrid
     */
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
     * The true main function with the simulation loop(cycles)
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
        paneArray = changePaneColorOnField(garden, paneArray);

        Object[][] gardenE = EntityGenerator.GenerateEntity();
        resetWasUsed(garden);
        assignHostsPlants(garden, gardenE);

        //Will launch example methods here, to check if they work

    }

    /**
     * Method that colors every pane inside gardenGrid based on the fieldType eg: grass = green
     * @param garden gardenGrid array that holds all the fields
     * @param paneArray Array that holds all Panes that are inside the GridPane gardenGrid
     * @return Modified (colored) array that holds all Panes that are inside the GridPane gardenGrid
     */
    public List<Pane> changePaneColorOnField(Field[][] garden, List<Pane> paneArray){
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
        return paneArray;
    }

    /**
     * Class made to reroute System.out.println() output to the designated TextArea field
     */
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
