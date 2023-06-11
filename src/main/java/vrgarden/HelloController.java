package vrgarden;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static vrgarden.Cabbage.Mutate;
import static vrgarden.Cabbage.SpreadAmount;
import static vrgarden.Field.assignHostsPlants;
import static vrgarden.Field.resetWasUsed;
import static vrgarden.Snail.Move;

public class HelloController {

    @FXML
    private TextArea console;
    private PrintStream ps;

    public void initialize() {
        ps = new PrintStream(new Console(console)) ;
    }

    @FXML
    public GridPane gardenGrid;

    public List<Object> paneArray = new ArrayList<>(100);

    /**
     * A method that adds all the program's panes to the grid pane
     * for later access
     *
     * @return
     */
    public List<Object> fillPaneArray() {
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

                paneArray.add(numberOfIndex, gardenGrid.getChildren().get(numberOfIndex));
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
        List<Object> paneArray = fillPaneArray();

        //Generate garden on button click
        Object[][] garden = GardenGenerator.GenerateGarden();
        changePaneColorOnField(garden);

        Object[][] gardenE = EntityGenerator.GenerateEntity();
        resetWasUsed(garden);
        assignHostsPlants(garden, gardenE);

        //Will launch example methods here, to check if they work
    }

    public void changePaneColorOnField(Object[][] garden){
        for (int i=0; i<HelloApplication.GARDEN_SIZE; i++){
            for (int j=0; j<HelloApplication.GARDEN_SIZE; j++){
                //if(garden[i][j].)
                //System.out.println("Debug" + garden[i][j]);
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
