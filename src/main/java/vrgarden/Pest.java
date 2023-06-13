package vrgarden;

import javafx.scene.layout.Pane;

import java.util.List;

import static vrgarden.HelloController.changeSinglePaneColor;

/**
 * Abstract class for the Pest objects
 */
public abstract class Pest {
    float lifespan;
    float reproductionRate;
    float hunger;
    float aggressiveness;
    String likedPlants;
    String hatedPlants;
    float climateResistance;

    /**
     * Makes pest eat nearby plant replenishing its health
     */
    public void Eat(){}

    /**
     * Makes another pest on the gardenGrid, somewhere next to the existing one
     */
    public void Reproduce(){}

    /**
     * Changes the statistics of a pest instance
     */
    public void Mutate(){}

    /**
     * Makes the pest move to another field in the gardenGrid
     */
    public void Move(){}

    /**
     * Deletes the pest from gardenGrid
     * @param gardenEntities array that holds all previously generated entities
     * @param x horizontal position on gardenGrid
     * @param y vertical position on gardenGrid
     */
    public static void Die(Object[][] gardenEntities, Field[][] garden, List<Pane> paneArray, int x, int y) {
        Object object = gardenEntities[x][y];

        if (object instanceof Cabbage cabbage) {
            if (cabbage.getLifespan() <= 0) {
                gardenEntities[x][y] = null;
                changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y);
            }
        } else if (object instanceof Snail snail) {
            if (snail.getLifespan() <= 0) {
                gardenEntities[x][y] = null;
                changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y);
            }
        } else if (object instanceof Weed weed) {
            if (weed.getLifespan() <= 0) {
                gardenEntities[x][y] = null;
                changeSinglePaneColor(gardenEntities, garden,  paneArray, x, y);
            }
        }
    }
    public static void LoseLHp(Object[][] gardenEntities, Field[][] garden, List<Pane> paneArray, int x, int y) {
        Object object = gardenEntities[x][y];

        if (object instanceof Cabbage cabbage) {
            cabbage.setLifespan(cabbage.getLifespan() - 1.0f);
        } else if (object instanceof Snail snail) {
            if(snail.getHunger()<=0){
                snail.setLifespan(snail.getLifespan() - 4.0f);
            }
        } else if (object instanceof Weed weed) {
            weed.setLifespan(weed.getLifespan() - 1.0f);
        }
    }

    /////////////////////////
    /////////GETTERS/////////
    /////////////////////////

    /**
     * @return hunger field of the pest
     */
    public float getHunger() {
        return hunger;
    }

    /**
     * @return likedPlant of the pest
     */
    public String getLikedPlants() {
        return likedPlants;
    }

    /**
     * @return hatedPlant of the pest
     */
    public String getHatedPlants() {
        return hatedPlants;
    }

    /**
     * @return lifespan field of the pest
     */
    public float getLifespan(){
        return lifespan;
    }

    /**
     * Sets hunger for the pest instance
     * @param hunger amount of hunger to be set
     */
    /////////////////////////
    /////////SETTERS/////////
    /////////////////////////
    public void setHunger(float hunger) {
        this.hunger = hunger;
    }
    public void setLifespan(float lifespan) {
        this.lifespan = lifespan;
    }
}

