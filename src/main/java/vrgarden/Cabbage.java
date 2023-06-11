package vrgarden;

/**
 * Cabbage object class
 */
public class Cabbage extends Flower{
    Cabbage(){
        super();
        this.lifespan = 20.0f;
        this.seedProductionPerCycle = 5;
        this.spreadSpeed = 1;
        this.climateResistance = 50.0f;
        this.mutationChance = 5;
        this.size = 5;
        this.likedPh = 6;
        this.hatedPh = 4;
    }
    
    Cabbage(float lifespan, float seedProductionPerCycle, float spreadSpeed, float climateResistance, float mutationChance, float size, float likedPh, float hatedPh){

        this.lifespan = lifespan;
        this.seedProductionPerCycle = seedProductionPerCycle;
        this.spreadSpeed = spreadSpeed;
        this.climateResistance = climateResistance;
        this.mutationChance = mutationChance;
        this.size = size;
        this.likedPh = likedPh;
        this.hatedPh = hatedPh;
    }

    Cabbage(Cabbage cabbage){
        this.lifespan = cabbage.lifespan;
        this.seedProductionPerCycle = cabbage.seedProductionPerCycle;
        this.spreadSpeed = cabbage.spreadSpeed;
        this.climateResistance = cabbage.climateResistance;
        this.mutationChance = cabbage.mutationChance;
        this.size = cabbage.size;
        this.likedPh = cabbage.likedPh;
        this.hatedPh = cabbage.hatedPh;
    }


    /**
    * Method that lets cabbage spread
    * @param gardenEntities array that hols all the Entities
    * @param x horizontal position of the Cabbage object on the garden grid
    * @param y vertical position of the Cabbage object on the garden grid
    */
    public static void SpreadAmount(Object[][] gardenEntities, int x, int y) {
        Object obj = gardenEntities[x][y];
        Cabbage cabbage = (Cabbage) obj;

        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenEntities[x - 1][y] == null) {
            gardenEntities[x - 1][y] = new Cabbage();
            System.out.println("Cabbage cloned itself and spread upwards.");
        } else if (direction == 1 && y < gardenEntities[0].length - 1 && gardenEntities[x][y + 1] == null) {
            gardenEntities[x][y + 1] = new Cabbage();
            System.out.println("Cabbage cloned itself and spread to the right.");
        } else if (direction == 2 && x < gardenEntities.length - 1 && gardenEntities[x + 1][y] == null) {
            gardenEntities[x + 1][y] = new Cabbage();
            System.out.println("Cabbage cloned itself and spread downwards.");
        } else if (direction == 3 && y > 0 && gardenEntities[x][y - 1] == null) {
            gardenEntities[x][y - 1] = new Cabbage();
            System.out.println("Cabbage cloned itself and spread to the left.");
        } else {
            System.out.println("Cabbage couldn't clone itself or spread to any direction.");
        }
    }

    /**
     * Method that makes cabbage change its statistics
     * @param gardenEntities array that hols all the Entities
     * @param x horizontal position of the Cabbage object on the garden grid
     * @param y vertical position of the Cabbage object on the garden grid
     */
    public static void Mutate(Object[][] gardenEntities, int x, int y) {
        Object obj = gardenEntities[x][y];
        Cabbage cabbage = (Cabbage) obj;
        float mutationChance = cabbage.mutationChance;

        int randomValue = (int) (Math.random() * 10) + 1;

        System.out.println(randomValue);
        if (randomValue >= mutationChance) {
            cabbage.setLifespan(cabbage.getLifespan() + 3.0f);
            System.out.println("Mutation occurred! Cabbage's lifespan increased by 3.");
        } else {
            System.out.println("No mutation occurred.");
        }
    }
}