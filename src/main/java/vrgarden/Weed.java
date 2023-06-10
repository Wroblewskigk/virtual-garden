package vrgarden;

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

    public void SpreadAmount(Weed[][] gardenE, int x, int y) {
        Weed weed = gardenE[x][y];
        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenE[x - 1][y] == null) {
            gardenE[x - 1][y] = new Weed();
            System.out.println("Weed cloned itself and spreaded upwards.");
        } else if (direction == 1 && y < gardenE[0].length - 1 && gardenE[x][y + 1] == null) {
            gardenE[x][y + 1] = new Weed();
            System.out.println("Weed cloned itself and spreaded to the right.");
        } else if (direction == 2 && x < gardenE.length - 1 && gardenE[x + 1][y] == null) {
            gardenE[x + 1][y] = new Weed();
            System.out.println("Weed cloned itself and spreaded downwards.");
        } else if (direction == 3 && y > 0 && gardenE[x][y - 1] == null) {
            gardenE[x][y - 1] = new Weed();
            System.out.println("Weed cloned itself and spreaded to the left.");
        } else {
            System.out.println("Weed couldn't spread to pointed direction.");
        }
    }

    public void Mutate(float mutationChance, int x, int y, Weed[][] gardenE) {
        Weed weed = gardenE[x][y];
        int randomValue = (int) (Math.random() * 10) + 1;

        if (randomValue <= mutationChance) {
            weed.setLifespan(weed.getLifespan() + 3.0f);
                System.out.println("Mutation occurred! Weed's lifespan increased by 3.");
        } else {
            System.out.println("No mutation occurred.");
        }
    }
}