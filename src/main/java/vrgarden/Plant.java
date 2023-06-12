package vrgarden;

/**
 * Abstract class Plant
 */
public abstract class Plant {
    float lifespan;
    float seedProductionPerCycle;
    float spreadSpeed;
    float climateResistance;
    float mutationChance;
    float size;
    float likedPh;
    float hatedPh;

    /**
     * Spreads the plant onto a nearby field
     */
    public void Spread(){}

    /**
     * Changes the statistics of a plant
     */
    public void Mutate(){}

    /////////////////////////
    /////////GETTERS/////////
    /////////////////////////

    /**
     * @return lifespan of a plant
     */
    public float getLifespan() {
        return this.lifespan;
    }

    /**
     * Sets the lifespan of the plant
     * @param lifespan the value that the lifespan field will be changed to
     */
    /////////////////////////
    /////////SETTERS/////////
    /////////////////////////
    public void setLifespan(float lifespan) {
        this.lifespan = lifespan;
    }
}

