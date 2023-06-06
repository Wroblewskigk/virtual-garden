package garden.virtualgarden;

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

    //ENTIRE PROGRAM LOGIC-----------------------------------------------------------------------------------------
    //Declaring GridPane taken from hello-view.fxml
    @FXML
    public GridPane gardenGrid;

    //Before I read that getChildren() returns Node list of children
    //public Pane[][] paneArray = new Pane[20][20];
    public List<Node> paneArray = new ArrayList<>(100);

    //Adding GridPane children to grid array, so I can access the children
    public List<Node> fillPaneArray() {
        for(int i=0; i<10; i++){
            for (int j=0; j<10; j++) {
                paneArray.set(i + j, gardenGrid.getChildren().get(i + j));
                System.out.println(paneArray.get(i+j));
            }
        }
        return paneArray;
    }

    public void button(ActionEvent ignoredEvent) {
        System.setOut(ps);
        System.setErr(ps);

        //Generate garden on button click
        GardenGenerator.GenerateGarden();
    }
    //-------------------------------------------------------------------------------------------------------------

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
