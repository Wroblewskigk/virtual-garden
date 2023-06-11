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
     * A method that adds all the program's panes to the grid pane
     * for later access
     */
    public void fillPaneArray() {
        for(int i=0; i<HelloApplication.GARDEN_SIZE; i++) {
            for (int j = 0; j <HelloApplication.GARDEN_SIZE; j++) {
                paneArray.set(i + j, gardenGrid.getChildren().get(i + j));
                System.out.println(paneArray.get(i + j));
            }
        }
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
        fillPaneArray();

        //Generate garden on button click
        Object[][] garden = GardenGenerator.GenerateGarden();
        //changePaneColorOnField(garden);

        Object[][] gardenE = EntityGenerator.GenerateEntity();

        //Will launch example methods here, to check if they work
    }

    /*
    public void changePaneColorOnField(Object[][] garden){
        for (int i=0; i<HelloApplication.GARDEN_SIZE; i++){
            for (int j=0; j<HelloApplication.GARDEN_SIZE; j++){
                System.out.println("Debug" + garden[i][j]);
            }
        }
    }
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
