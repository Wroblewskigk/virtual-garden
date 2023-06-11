package vrgarden;

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
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                if (garden[i][j] instanceof Dirt) {
                    ((Dirt) garden[i][j]).setWasUsed(false);
                } else if (garden[i][j] instanceof Sand) {
                    ((Sand) garden[i][j]).setWasUsed(false);
                } else if (garden[i][j] instanceof Grass) {
                    ((Grass) garden[i][j]).setWasUsed(false);
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