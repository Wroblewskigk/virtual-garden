package vrgarden;

/**
 * Superclass of classes such as: dirt, sand and other
 * blocks that can be placed on the garden grid
 */
public abstract class Field {
    String fieldType;
    float ph;
    float temperature;
    float sunAmount;
    float wetness;
    float rain;
    String hostsPlants;
    boolean wasUsed;

    /**
     * Starts rain on a field
     */
    public void MakeRain(){}

    /**
     * Stops rain on a field
     */
    public void StopRain(){}

    /**
     * Method that changes temperature on a field
     */
    public void ChangeTemperature(){}

    /**
     * Method that changes the amount of sun on a field
     */
    public void ChangeSun(){}

    /**
     * Method to flood or un-flood a field
     */
    public void Flood(){}

    /**
     * Resets the wasUsed parameter of a field
     * @param garden array that holds all the fields that are on the gardenGrid
     */
    public static void resetWasUsed(Object[][] garden) {
        for (Object[] objects : garden) {
            for (Object object : objects) {
                if (object instanceof Dirt) {
                    ((Dirt) object).setWasUsed(false);
                } else if (object instanceof Sand) {
                    ((Sand) object).setWasUsed(false);
                } else if (object instanceof Grass) {
                    ((Grass) object).setWasUsed(false);
                }
            }
        }
    }

    /**
     * Assigns an entity to the field that it's standing on. Not necessarily a plant
     * @param garden array that holds all the fields that are on the gardenGrid
     * @param gardenEntities array that hols all the Entities
     */
    public static void assignHostsPlants(Object[][] garden, Object[][] gardenEntities) {

        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden.length; j++) {
                Object field = garden[i][j];
                Field f = (Field) field;
                f.hostsPlants = findPlantType(gardenEntities[i][j]);
            }
        }
    }

    private static String findPlantType(Object object) {
        if (object instanceof Cabbage) {
            return "Cabbage";
        } else if (object instanceof Snail) {
            return "None";
        } else if (object instanceof Weed) {
            return "Weed";
        } else {
            return "None";
        }
    }

    @Override
    public String toString() {
        return "Field{Type=" + fieldType + "}";
    }

    /////////////////////////
    /////////GETTERS/////////
    /////////////////////////

    /**
     * Getter for the hostPlants parameter of a field
     * @return name of the plant that is currently on the field
     */
    public String getHostsPlants() {
        return this.hostsPlants;
    }

    /**
     * Getter for the fieldType parameter of a field
     * @return name of the type of field
     */
    public String getFieldType(){
        return this.fieldType;
    }

    /////////////////////////
    /////////SETTERS/////////
    /////////////////////////

    /**
     * Sets the wasUsed value of the field
     * @param wasUsed boolean value that holds if the field has taken its turn in a cycle
     */
    public void setWasUsed(boolean wasUsed) {
        this.wasUsed = wasUsed;
    }
}