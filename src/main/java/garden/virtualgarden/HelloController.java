package garden.virtualgarden;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

public class HelloController {

    @FXML
    private TextArea console;
    private PrintStream ps ;

    public void initialize() {
        ps = new PrintStream(new Console(console)) ;
    }

    public void button(ActionEvent ignoredEvent) {
        System.setOut(ps);
        System.setErr(ps);
        GardenGenerator.GenerateGarden();
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
