package vrgarden;

public abstract class Pest {
    float lifespan;
    float reproductionRate;
    float hunger;
    float aggressiveness;
    String likedPlants;
    String hatedPlants;
    float climateResistance;

    public void Eat(){}
    public void Reproduce(){}
    public void Mutate(){}
    public void Move(){}
    public static void Die(Object[][] gardenE, int x, int y) {
        Object object = gardenE[x][y];

        if (object instanceof Cabbage) {
            Cabbage cabbage = (Cabbage) object;
            if (cabbage.getLifespan() <= 0) {
                gardenE[x][y] = null;
            }
        } else if (object instanceof Snail) {
            Snail snail = (Snail) object;
            if (snail.getLifespan() <= 0) {
                gardenE[x][y] = null;
            }
        } else if (object instanceof Weed) {
            Weed weed = (Weed) object;
            if (weed.getLifespan() <= 0) {
                gardenE[x][y] = null;
            }
        }
    }

    /////////////////////////
    /////////GETTERS/////////
    /////////////////////////

    public float getHunger() {
        return hunger;
    }
    public String getLikedPlants() {
        return likedPlants;
    }
    public String getHatedPlants() {
        return hatedPlants;
    }
    public float getLifespan(){
        return lifespan;
    }
    /////////////////////////
    /////////SETTERS/////////
    /////////////////////////
    public void setHunger(float hunger) {
        this.hunger = hunger;
    }
}

