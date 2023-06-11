package vrgarden;

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

    public static void SpreadAmount(Object[][] gardenE, int x, int y) {
        Object obj = gardenE[x][y];
        Cabbage cabbage = (Cabbage) obj;
        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenE[x - 1][y] == null) {
            gardenE[x - 1][y] = new Cabbage();
            System.out.println("Cabbage cloned itself and spreaded upwards.");
        } else if (direction == 1 && y < gardenE[0].length - 1 && gardenE[x][y + 1] == null) {
            gardenE[x][y + 1] = new Cabbage();
            System.out.println("Cabbage cloned itself and spreaded to the right.");
        } else if (direction == 2 && x < gardenE.length - 1 && gardenE[x + 1][y] == null) {
            gardenE[x + 1][y] = new Cabbage();
            System.out.println("Cabbage cloned itself and spreaded downwards.");
        } else if (direction == 3 && y > 0 && gardenE[x][y - 1] == null) {
            gardenE[x][y - 1] = new Cabbage();
            System.out.println("Cabbage cloned itself and spreaded to the left.");
        } else {
            System.out.println("Cabbage couldn't clone itself or spread to any direction.");
        }
    }

    public static void Mutate(Object[][] gardenE, int x, int y) {
        Object obj = gardenE[x][y];
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