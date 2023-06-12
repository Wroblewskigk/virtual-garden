package vrgarden;

/**
 * Harmful for flowers plant type entity, that can generate on the gardenGrid
 */
public class Weed extends Plant{
    Weed(){
        this.lifespan = 20.0f;
        this.seedProductionPerCycle = 5;
        this.spreadSpeed = 1;
        this.climateResistance = 50.0f;
        this.mutationChance = 5;
        this.size = 5;
        this.likedPh = 6;
        this.hatedPh = 4;
    }

    Weed(float lifespan, float seedProductionPerCycle, float spreadSpeed, float climateResistance, float mutationChance, float size, float likedPh, float hatedPh){

        this.lifespan = lifespan;
        this.seedProductionPerCycle = seedProductionPerCycle;
        this.spreadSpeed = spreadSpeed;
        this.climateResistance = climateResistance;
        this.mutationChance = mutationChance;
        this.size = size;
        this.likedPh = likedPh;
        this.hatedPh = hatedPh;
    }

    Weed(Weed weed){
        this.lifespan = weed.lifespan;
        this.seedProductionPerCycle = weed.seedProductionPerCycle;
        this.spreadSpeed = weed.spreadSpeed;
        this.climateResistance = weed.climateResistance;
        this.mutationChance = weed.mutationChance;
        this.size = weed.size;
        this.likedPh = weed.likedPh;
        this.hatedPh = weed.hatedPh;
    }

    /**
     * Method that duplicates cabbage onto a nearby field
     * @param gardenEntityArray array that hols all the Entities
     * @param x horizontal position of the Cabbage object on the garden grid
     * @param y vertical position of the Cabbage object on the garden grid
     */
    public static void Spread(Object[][] gardenEntityArray, int x, int y) {
        Object obj = gardenEntityArray[x][y];
        Weed weed = (Weed) obj;
        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenEntityArray[x - 1][y] == null) {
            gardenEntityArray[x - 1][y] = new Weed();
            System.out.println("Weed cloned itself and spread upwards.");
        } else if (direction == 1 && y < gardenEntityArray[0].length - 1 && gardenEntityArray[x][y + 1] == null) {
            gardenEntityArray[x][y + 1] = new Weed();
            System.out.println("Weed cloned itself and spread to the right.");
        } else if (direction == 2 && x < gardenEntityArray.length - 1 && gardenEntityArray[x + 1][y] == null) {
            gardenEntityArray[x + 1][y] = new Weed();
            System.out.println("Weed cloned itself and spread downwards.");
        } else if (direction == 3 && y > 0 && gardenEntityArray[x][y - 1] == null) {
            gardenEntityArray[x][y - 1] = new Weed();
            System.out.println("Weed cloned itself and spread to the left.");
        } else {
            System.out.println("Weed couldn't spread to pointed direction.");
        }
    }

    /**
     * Changes statistics of entities on a gardenGrid
     * @param gardenEntityArray array that hols all the Entities
     * @param x horizontal position of the Cabbage object on the garden grid
     * @param y vertical position of the Cabbage object on the garden grid
     */
    public static void Mutate(Object[][] gardenEntityArray, int x, int y) {
        Object obj = gardenEntityArray[x][y];
        Weed weed = (Weed) obj;
        float mutationChance = weed.mutationChance;
        int randomValue = (int) (Math.random() * 10) + 1;

        if (randomValue <= mutationChance) {
            weed.setLifespan(weed.getLifespan() + 3.0f);
                System.out.println("Mutation occurred! Weed's lifespan increased by 3.");
        } else {
            System.out.println("No mutation occurred.");
        }
    }
}