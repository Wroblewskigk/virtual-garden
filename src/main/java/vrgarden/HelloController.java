package vrgarden;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    public List<Node> paneArray = new ArrayList<>(100);

    /**
     * @return ArrayList of type NODE
     * A method that adds all of the program's panes to the gridpane
     * for later access
     */
    public List<Node> fillPaneArray() {
        for(int i=0; i<10; i++){
            for (int j=0; j<10; j++) {
                paneArray.set(i + j, gardenGrid.getChildren().get(i + j));
                System.out.println(paneArray.get(i+j));
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

        //Generate garden on button click
        Object[][] garden = GardenGenerator.GenerateGarden();
        Object[][] gardenE = EntityGenerator.GenerateEntity();
        resetWasUsed(garden);
        assignHostsPlants(garden, gardenE);

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
