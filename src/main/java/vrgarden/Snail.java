package vrgarden;

public class Snail extends Pest{

    Snail(){
        this.lifespan = 10.0f;
        this.reproductionRate = 2.0f;
        this.hunger = 10.0f;
        this.aggressiveness = 2.0f;
        this.likedPlants = "Cabbage";
        this.hatedPlants = "Tomatoes";
        this.climateResistance = 50.0f;
    }

    Snail(float lifespan, float reproductionRate, float hunger,
          float aggressiveness, String likedPlants, String hatedPlants,
          float climateResistance){

        this.lifespan = lifespan;
        this.reproductionRate = reproductionRate;
        this.hunger = hunger;
        this.aggressiveness = aggressiveness;
        this.likedPlants = likedPlants;
        this.hatedPlants = hatedPlants;
        this.climateResistance = climateResistance;
    }

    Snail(Snail snail){
        this.lifespan = snail.lifespan;
        this.reproductionRate = snail.reproductionRate;
        this.hunger = snail.hunger;
        this.aggressiveness = snail.aggressiveness;
        this.likedPlants = snail.likedPlants;
        this.hatedPlants = snail.hatedPlants;
        this.climateResistance = snail.climateResistance;
    }

    public static void Move(Object[][] gardenE, int x, int y) {
        Object obj = gardenE[x][y];
        Snail snail = (Snail) obj;
        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenE[x - 1][y] == null) {
            gardenE[x - 1][y] = snail;
            gardenE[x][y] = null;
            System.out.println("Snail moved upwards.");
        } else if (direction == 1 && y < gardenE[0].length - 1 && gardenE[x][y + 1] == null) {
            gardenE[x][y + 1] = snail;
            gardenE[x][y] = null;
            System.out.println("Snail moved to the right.");
        } else if (direction == 2 && x < gardenE.length - 1 && gardenE[x + 1][y] == null) {
            gardenE[x + 1][y] = snail;
            gardenE[x][y] = null;
            System.out.println("Snail and moved downwards.");
        } else if (direction == 3 && y > 0 && gardenE[x][y - 1] == null) {
            gardenE[x][y - 1] = snail;
            gardenE[x][y] = null;
            System.out.println("Snail moved to the left.");
        } else {
            System.out.println("Snail couldn't move to pointed direction.");
        }
    }

    public static void Reproduce(Object[][] gardenE, int x, int y) {
        Object obj = gardenE[x][y];
        Snail snail = (Snail) obj;
        int direction = (int) (Math.random() * 4);

        if (direction == 0 && x > 0 && gardenE[x - 1][y] == null) {
            gardenE[x - 1][y] = new Snail();
            System.out.println("Snail cloned itself and reproduced upwards.");
        } else if (direction == 1 && y < gardenE[0].length - 1 && gardenE[x][y + 1] == null) {
            gardenE[x][y + 1] = new Snail();
            System.out.println("Snail cloned itself and reproduced to the right.");
        } else if (direction == 2 && x < gardenE.length - 1 && gardenE[x + 1][y] == null) {
            gardenE[x + 1][y] = new Snail();
            System.out.println("Snail cloned itself and reproduced downwards.");
        } else if (direction == 3 && y > 0 && gardenE[x][y - 1] == null) {
            gardenE[x][y - 1] = new Snail();
            System.out.println("Snail cloned itself and reproduced to the left.");
        } else {
            System.out.println("Snail couldn't reproduce to pointed direction.");
        }
    }

}