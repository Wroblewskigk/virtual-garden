package garden.virtualgarden;

import java.util.Random;
public class GardenGenerator {
    private static final int GARDEN_SIZE = 10;

    private static final String[] FIELD_TYPES = {"Dirt", "Sand", "Grass"};

    static Object[][] garden = new Object[GARDEN_SIZE][GARDEN_SIZE];
    public static void GenerateGarden() {
        String fieldType;
        for (int i=0; i<GARDEN_SIZE; i++) {
            for (int j=0; j<GARDEN_SIZE; j++){
                fieldType = getRandomElement();
                switch (fieldType) {
                    case "Dirt" -> garden[i][j] = new Dirt();
                    case "Grass" -> garden[i][j] = new Grass();
                    case "Sand" -> garden[i][j] = new Sand();
                }
                System.out.println(garden[i][j]);
            }
        }
    }
    private static String getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(GardenGenerator.FIELD_TYPES.length);
        return GardenGenerator.FIELD_TYPES[index];
    }
}
