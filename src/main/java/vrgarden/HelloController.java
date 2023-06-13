package vrgarden;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static vrgarden.Field.assignHostsPlants;
import static vrgarden.Field.resetWasUsed;

/**
 * Class that holds main() method and all the logic for the controllers such as: buttons, textAreas ect.
 */
public class HelloController {

    /**
     * TextArea to which the outputStream will be directed
     */
    @FXML
    private TextArea console;

    /**
     * I don't remember
     */
    private PrintStream ps;

    /**
     * Method that initializes Console object
     */
    public void initialize() {
        ps = new PrintStream(new Console(console)) ;
    }

    /**
     * Variable that holds gardenGrid grid pane
     */
    @FXML
    public GridPane gardenGrid;

    /**
     * Array that holds all Panes that are inside the GridPane 'gardenGrid'
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
                //System.out.println(paneArray.get(numberOfIndex));
            }
        }
        return paneArray;
    }

    /**
     * The true main function with the simulation loop(cycles)
     * Method that start the entire simulation. Think of it as replacement
     *      * for the 'main' method
     * @param ignoredEvent parameter necessary for function to work, that is given by the
     *                     vrgarden/resources/vrgarden/hello-view.fxml file
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
        renderEntities(gardenEntities, paneArray);

        //Arrays of possible moves for an entity
        String[] snailMoves = {"Move", "Reproduce", "Eat", "Nothing"};
        String[] cabbageMoves = {"Mutate", "Spread", "Nothing"};

        //Main simulation loop
        for (int i=0; i<HelloApplication.SIMULATION_CYCLES_AMOUNT; i++){
            //Loop through the entire entityArray and randomize their actions
            for (int x=0; x<HelloApplication.GARDEN_SIZE; x++){
                for (int y=0; y<HelloApplication.GARDEN_SIZE; y++){

                    if (gardenEntities[x][y] instanceof  Cabbage){

                    }
                    if (gardenEntities[x][y] instanceof Snail){

                    }
                }
            }

            resetWasUsed(garden);
            assignHostsPlants(garden, gardenEntities);
        }
    }

    /**
     * Method that colors every pane inside gardenGrid based on the fieldType eg: grass = green
     * @param garden gardenGrid array that holds all the fields
     * @param paneArray array that holds all Panes that are inside the GridPane gardenGrid
     */
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

    /**
     * Renders entities onto the gardenGrid
     * @param gardenEntities array of generated entities
     * @param paneArray array of panes inside gardenGrid
     */
    public void renderEntities(Object[][] gardenEntities, List<Pane> paneArray) {

        for (int i = 0; i < HelloApplication.GARDEN_SIZE; i++) {
            for (int j = 0; j < HelloApplication.GARDEN_SIZE; j++) {
                if (gardenEntities[i][j] instanceof  Cabbage) {
                    System.out.println("BLUE Cabbage: " + gardenEntities[i][j]);

                    paneArray.get(i*10+j).setBackground(new Background(new BackgroundFill(
                            Color.web("#23aea3"), CornerRadii.EMPTY, Insets.EMPTY)));
                }

                if (gardenEntities[i][j] instanceof  Snail) {
                    System.out.println("BLACK Snail: " + gardenEntities[i][j]);

                    paneArray.get(i*10+j).setBackground(new Background(new BackgroundFill(
                            Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
    }

    /**
     * Class made to reroute System.out.println() output to the designated TextArea field
     */
    public static class Console extends OutputStream {
        private final TextArea console;

        /**
         * Copying constructor for console class
         * @param console object of type Console
         */
        public Console(TextArea console) {
            this.console = console;
        }

        /**
         * Method responsible for appending output stream to the textField node
         * @param valueOf is responsible for holding a single line of output stream
         */
        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) {
            appendText(String.valueOf((char)b));
        }
    }
}
