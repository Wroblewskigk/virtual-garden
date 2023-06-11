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

    public void MakeRain(){}
    public void StopRain(){}
    public void ChangeTemperature(){}
    public void ChangeSun(){}
    public void Flood(){}

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

    public static void assignHostsPlants(Object[][] garden, Object[][] gardenE) {

        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden.length; j++) {
                Object field = garden[i][j];
                Field f = (Field) field;
                f.hostsPlants = findPlantType(gardenE[i][j]);
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
    /////////SETTERS/////////
    /////////////////////////

    public void setWasUsed(boolean wasUsed) {
        this.wasUsed = wasUsed;
    }
}