package vrgarden;
import java.util.Random;

/**
 * Class made to generate initial entities
 */
public class EntityGenerator {
    private static final String[] ENTITY_TYPES = {"Snail", "Cabbage", "Cabbage2", "Weed", "Weed2", "None1", "None2", "None3", "None4",
                                                  "None5", "None6", "None7"};

    /**
     * Array that will hold all generated entities
     */
    static Object[][] gardenEntityArray = new Object[HelloApplication.GARDEN_SIZE][HelloApplication.GARDEN_SIZE];

    /**
     * Method used to generate array of random entities
     * @return the array of objects onto the gardenGrid
     */
    //Function returns the array of objects placeable on garden fields
    public static Object[][] GenerateEntity() {

        String entityType;
        for (int i = 0; i < HelloApplication.GARDEN_SIZE; i++) {
            for (int j = 0; j < HelloApplication.GARDEN_SIZE; j++) {
                entityType = getRandomElement();
                switch (entityType) {
                    case "None1", "None2", "None3", "None4", "None5", "None6", "None7" -> gardenEntityArray[i][j] = null;
                    case "Snail" -> gardenEntityArray[i][j] = new Snail();
                    case "Cabbage", "Cabbage2" -> gardenEntityArray[i][j] = new Cabbage();
                    case "Weed", "Weed2" -> gardenEntityArray[i][j] = new Weed();
                }
                //System.out.println("Created entity " + gardenEntityArray[i][j]);
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