package vrgarden;
import java.util.Random;

public class EntityGenerator {
    private static final int GARDEN_SIZE = 10;

    private static final String[] ENTITY_TYPES = {"Snail", "Cabbage", "Weed", "None1", "None2", "None3"};

    static Object[][] gardenv = new Object[10][10];

    //Function returns the array of objects placable on garden fields
    public static Object[][] GenerateEntity() {

        String entityType;
        for (int i = 0; i < GARDEN_SIZE; i++) {
            for (int j = 0; j < GARDEN_SIZE; j++) {
                entityType = getRandomElement(ENTITY_TYPES);
                switch (entityType) {
                    case "None1" -> gardenv[i][j] = null;
                    case "None2" -> gardenv[i][j] = null;
                    case "None3" -> gardenv[i][j] = null;
                    case "Snail" -> gardenv[i][j] = new Snail();
                    case "Cabbage" -> gardenv[i][j] = new Cabbage();
                    case "Weed" -> gardenv[i][j] = new Weed();
                }
                System.out.println(gardenv[i][j]);
            }
        }
        return gardenv;
    }

    private static String getRandomElement(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}