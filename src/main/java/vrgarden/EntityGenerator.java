package vrgarden;
import java.util.Random;

public class EntityGenerator {
    private static final String[] ENTITY_TYPES = {"Snail", "Cabbage", "Weed", "None1", "None2", "None3"};

    static Object[][] gardenEntityArray = new Object[HelloApplication.GARDEN_SIZE][HelloApplication.GARDEN_SIZE];

    //Function returns the array of objects placeable on garden fields
    public static Object[][] GenerateEntity() {

        String entityType;
        for (int i = 0; i < HelloApplication.GARDEN_SIZE; i++) {
            for (int j = 0; j < HelloApplication.GARDEN_SIZE; j++) {
                entityType = getRandomElement();
                switch (entityType) {
                    case "None1" -> gardenv[i][j] = null;
                    case "None2" -> gardenv[i][j] = null;
                    case "None3" -> gardenv[i][j] = null;
                    case "Snail" -> gardenv[i][j] = new Snail();
                    case "Cabbage" -> gardenv[i][j] = new Cabbage();
                    case "Weed" -> gardenv[i][j] = new Weed();
                }
                System.out.println("Created entity " + gardenEntityArray[i][j]);
            }
        }
        return gardenEntityArray;
    }

    private static String getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(EntityGenerator.ENTITY_TYPES.length);
        return EntityGenerator.ENTITY_TYPES[index];
    }
}