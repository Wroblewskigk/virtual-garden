package vrgarden;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class with the main() method and link to the fxml file.
 * Even though it has the main() method the loop of the simulation
 * is inside the HelloController classes button() method
 */
public class HelloApplication extends Application {

    /**
     * Sets the size of the garden
     */
    public static final int GARDEN_SIZE = 10;

    /**
     * Specifies the amount of cycles that will take place in the main loop of a simulation
     */
    public static final int SIMULATION_CYCLES_AMOUNT = 40;

    /**
     * Method executed before main() method. The main() method executes button()
     * method indirectly inside helloController.java
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setScene(scene);
            stage.setMinHeight(700);
            stage.setMinWidth(500);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The main() method. The true main method with the loop of the simulation
     * is inside the HelloController classes button() method
     * @param args arguments that can be passed to launch() function
     */
    public static void main(String[] args) {
        launch(args);
    }
}