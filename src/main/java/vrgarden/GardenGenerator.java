package vrgarden;

import java.util.Random;

/**
 * Class responsible for generating the garden grid for
 * plants, pests etc. to be on
 */
public class GardenGenerator {
    private static final String[] FIELD_TYPES = {"Dirt", "Sand", "Grass"};

    static Field[][] garden = new Field[HelloApplication.GARDEN_SIZE][HelloApplication.GARDEN_SIZE];

    /**
     * Generates fields such as dirt,sand ect. and adds them to the gardenGrid
     * @return Array of Objects that represent types of fields
     * that are generated on the map
     */
    public static Field[][] GenerateGarden() {
        String fieldType;
        for (int i=0; i<HelloApplication.GARDEN_SIZE; i++) {
            for (int j=0; j<HelloApplication.GARDEN_SIZE; j++){
                fieldType = getRandomElement();
                switch (fieldType) {
                    case "Dirt" -> garden[i][j] = new Dirt();
                    case "Grass" -> garden[i][j] = new Grass();
                    case "Sand" -> garden[i][j] = new Sand();
                }
                //System.out.println("Created field " + garden[i][j]);
            }
        }
        return garden;
    }
    private static String getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(GardenGenerator.FIELD_TYPES.length);
        return GardenGenerator.FIELD_TYPES[index];
    }
}
