package garden.virtualgarden;
import java.util.Random;
public class GardenGenerator {
    private static final int GARDEN_SIZE = 20;

    private static final String[] FIELD_TYPES = {"Dirt", "Sand", "Grass"};

    static Object[][] garden = new Object[20][20];
    public static Object[][] GenerateGarden() {

        String fieldType;
        for (int i=0; i<GARDEN_SIZE; i++) {
            for (int j=0; j<GARDEN_SIZE; j++){
                fieldType = getRandomElement(FIELD_TYPES);
                switch (fieldType) {
                    case "Dirt" -> garden[i][j] = new Dirt();
                    case "Grass" -> garden[i][j] = new Grass();
                    case "Sand" -> garden[i][j] = new Sand();
                }
                System.out.println(garden[i][j]);
            }
        }
        return garden;
    }
    private static String getRandomElement(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}
