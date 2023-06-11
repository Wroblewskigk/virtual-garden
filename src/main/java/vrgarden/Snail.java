package vrgarden;

public class Snail extends Pest{

    /**
     *Default constructor dor Snail class
     */
    Snail(){
        this.lifespan = 10.0f;
        this.reproductionRate = 2.0f;
        this.hunger = 10.0f;
        this.aggressiveness = 2.0f;
        this.likedPlants = "Cabbage";
        this.hatedPlants = "Tomatoes";
        this.climateResistance = 50.0f;
    }

    /**
     * @param lifespan Sets snail's lifespan
     * @param reproductionRate Sets snail's reproductionRate
     * @param hunger Sets snail's hunger
     * @param aggressiveness Sets snail's aggressiveness
     * @param likedPlants Sets snail's likedPlants
     * @param hatedPlants Sets snail's hatedPlants
     * @param climateResistance Sets snail's climateResistance
     * Parameterized constructor for the Snail class
     */
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

    /**
     * @param snail Existing instance of a class Snail
     * Copying constructor for the Snail class
     */
    Snail(Snail snail){
        this.lifespan = snail.lifespan;
        this.reproductionRate = snail.reproductionRate;
        this.hunger = snail.hunger;
        this.aggressiveness = snail.aggressiveness;
        this.likedPlants = snail.likedPlants;
        this.hatedPlants = snail.hatedPlants;
        this.climateResistance = snail.climateResistance;
    }

     /**
     * @param gardenE
     * @param x
     * @param y
     */
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

    public static void Eat(Object[][] gardenE, Object[][] garden, int x, int y) {
        Snail snail = (Snail) gardenE[x][y];
        int direction = (int) (Math.random() * 4);

        int newX = x;
        int newY = y;

        if (direction == 0 && x > 0) {
            newX = x - 1;
        } else if (direction == 1 && y < gardenE[0].length - 1) {
            newY = y + 1;
        } else if (direction == 2 && x < gardenE.length - 1) {
            newX = x + 1;
        } else if (direction == 3 && y > 0) {
            newY = y - 1;
        }

        Object plant = gardenE[newX][newY];
        Field field = (Field) garden[newX][newY];;
        if (plant != null) {
            if (plant instanceof Cabbage) {
                Cabbage cabbage = (Cabbage) gardenE[newX][newY];
                if (cabbage.getLifespan() > 0) {
                        snail.setHunger(Math.min(snail.getHunger() + 3, 10));
                        cabbage.setLifespan(cabbage.getLifespan() - 3);
                        System.out.println("Snail ate a Cabbage (Favorite)!");
                }
            } else if (plant instanceof Weed) {
                Weed weed = (Weed) gardenE[newX][newY];
                if (weed.getLifespan() > 0) {
                    snail.setHunger(Math.min(snail.getHunger() + 2, 10));
                    weed.setLifespan(weed.getLifespan() - 2);
                    System.out.println("Snail ate a Weed!");
                }
            }
        } else {
            System.out.println("No plant found in the direction.");
        }
    }

}