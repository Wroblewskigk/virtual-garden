package vrgarden;

import javafx.scene.layout.Pane;

import java.util.List;

import static vrgarden.HelloController.changeSinglePaneColor;

/**
 * Class made to create pests of type Snails
 */
public class Snail extends Pest{

    static int snailCounter;

    /**
     *Default constructor dor Snail class
     */
    Snail(){
        this.lifespan = 4.0f;
        this.reproductionRate = 2.0f;
        this.hunger = 10.0f;
        this.aggressiveness = 2.0f;
        this.likedPlants = "Cabbage";
        this.hatedPlants = "Tomatoes";
        this.climateResistance = 50.0f;
        snailCounter++;
    }

    /**
     * @param lifespan Sets snail's lifespan
     * @param reproductionRate Sets snail's reproductionRate
     * @param hunger Sets snail's hunger
     * @param aggressiveness Sets snail's aggressiveness
     * @param likedPlants Sets snail's likedPlants
     * @param hatedPlants Sets snail's hatedPlants
     * @param climateResistance Sets snail's climateResistance
     * Parameterized constructor for the Snail class
     */
    Snail(float lifespan, float reproductionRate, float hunger,
          float aggressiveness, String likedPlants, String hatedPlants,
          float climateResistance){

        this.lifespan = lifespan;
        this.reproductionRate = reproductionRate;
        this.hunger = hunger;
        this.aggressiveness = aggressiveness;
        this.likedPlants = likedPlants;
        this.hatedPlants = hatedPlants;
        this.climateResistance = climateResistance;
        snailCounter++;
    }

    /**
     * @param snail Existing instance of a class Snail
     * Copying constructor for the Snail class
     */
    Snail(Snail snail){
        this.lifespan = snail.lifespan;
        this.reproductionRate = snail.reproductionRate;
        this.hunger = snail.hunger;
        this.aggressiveness = snail.aggressiveness;
        this.likedPlants = snail.likedPlants;
        this.hatedPlants = snail.hatedPlants;
        this.climateResistance = snail.climateResistance;
        snailCounter++;
    }

     /**
      * Method used by snail to move
      * @param gardenEntities array that holds all previously generated entities
      * @param garden gardenGrid array that holds all the fields
      * @param paneArray array that holds all Panes that are inside the GridPane gardenGrid
      * @param x horizontal position on gardenGrid
      * @param y vertical position on gardenGrid
      */
    public static void Move(Object[][] gardenEntities, Field[][] garden, List< Pane > paneArray, int x, int y) {
        Object obj = gardenEntities[x][y];
        Snail snail = (Snail) obj;

        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenEntities[x - 1][y] == null) {
            gardenEntities[x - 1][y] = snail;
            gardenEntities[x][y] = null;
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y);
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x-1, y);
            System.out.println("Snail moved upwards.");
        } else if (direction == 1 && y < gardenEntities[0].length - 1 && gardenEntities[x][y + 1] == null) {
            gardenEntities[x][y + 1] = snail;
            gardenEntities[x][y] = null;
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y);
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y+1);
            System.out.println("Snail moved to the right.");
        } else if (direction == 2 && x < gardenEntities.length - 1 && gardenEntities[x + 1][y] == null) {
            gardenEntities[x + 1][y] = snail;
            gardenEntities[x][y] = null;
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y);
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x+1, y);
            System.out.println("Snail and moved downwards.");
        } else if (direction == 3 && y > 0 && gardenEntities[x][y - 1] == null) {
            gardenEntities[x][y - 1] = snail;
            gardenEntities[x][y] = null;
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y);
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y-1);
            System.out.println("Snail moved to the left.");
        } else {
            System.out.println("Snail couldn't move to pointed direction.");
        }
    }

    /**
     * Method that clones Snail onto a nearby field
     * @param gardenEntities array that holds all previously generated entities
     * @param garden gardenGrid array that holds all the fields
     * @param paneArray array that holds all Panes that are inside the GridPane gardenGrid
     * @param x horizontal position on gardenGrid
     * @param y vertical position on gardenGrid
     */
    public static void Reproduce(Object[][] gardenEntities, Field[][] garden, List< Pane > paneArray, int x, int y) {
        Object obj = gardenEntities[x][y];
        Snail snail = (Snail) obj;
        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenEntities[x - 1][y] == null) {
            gardenEntities[x - 1][y] = new Snail();
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x-1, y);
            System.out.println("Snail cloned itself and reproduced upwards.");
        } else if (direction == 1 && y < gardenEntities[0].length - 1 && gardenEntities[x][y + 1] == null) {
            gardenEntities[x][y + 1] = new Snail();
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y+1);
            System.out.println("Snail cloned itself and reproduced to the right.");
        } else if (direction == 2 && x < gardenEntities.length - 1 && gardenEntities[x + 1][y] == null) {
            gardenEntities[x + 1][y] = new Snail();
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x+1, y);
            System.out.println("Snail cloned itself and reproduced downwards.");
        } else if (direction == 3 && y > 0 && gardenEntities[x][y - 1] == null) {
            gardenEntities[x][y - 1] = new Snail();
            changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y-1);
            System.out.println("Snail cloned itself and reproduced to the left.");
        } else {
            System.out.println("Snail couldn't reproduce to pointed direction.");
        }
    }

    /**
     * @param gardenEntities array that holds all previously generated entities
     * @param garden array that holds all previously generated fields
     * @param x horizontal position on gardenGrid
     * @param y vertical position on gardenGrid
     */
    public static void Eat(Object[][] gardenEntities, Object[][] garden, int x, int y) {
        Snail snail = (Snail) gardenEntities[x][y];
        int direction = (int) (Math.random() * 4);

        int newX = x;
        int newY = y;

        if (direction == 0 && x > 0) {
            newX = x - 1;
        } else if (direction == 1 && y < gardenEntities[0].length - 1) {
            newY = y + 1;
        } else if (direction == 2 && x < gardenEntities.length - 1) {
            newX = x + 1;
        } else if (direction == 3 && y > 0) {
            newY = y - 1;
        }

        Object plant = gardenEntities[newX][newY];
        Field field = (Field) garden[newX][newY];
        if (plant != null) {
            if (plant instanceof Cabbage) {
                Cabbage cabbage = (Cabbage) gardenEntities[newX][newY];
                if (cabbage.getLifespan() > 0) {
                        snail.setHunger(Math.min(snail.getHunger() + 3, 10));
                        cabbage.setLifespan(cabbage.getLifespan() - 3);
                        System.out.println("Snail ate a Cabbage (Favorite)!");
                }
            } else if (plant instanceof Weed) {
                Weed weed = (Weed) gardenEntities[newX][newY];
                if (weed.getLifespan() > 0) {
                    snail.setHunger(Math.min(snail.getHunger() + 2, 10));
                    weed.setLifespan(weed.getLifespan() - 2);
                    System.out.println("Snail ate a Weed!");
                }
            }
        } else {
            System.out.println("No plant found in the direction.");
        }
    }

}