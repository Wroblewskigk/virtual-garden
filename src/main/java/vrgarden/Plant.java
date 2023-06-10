package vrgarden;

public abstract class Plant {
    float lifespan;
    float seedProductionPerCycle;
    float spreadSpeed;
    float climateResistance;
    float mutationChance;
    float size;
    float likedPh;
    float hatedPh;

    public void MakeSeed(){}
    public void SpreadAmount(){}
    public void Mutate(){}

    /////////////////////////
    /////////GETTERS/////////
    /////////////////////////

    public float getLifespan() {
        return this.lifespan;
    }

    /////////////////////////
    /////////SETTERS/////////
    /////////////////////////
    public void setLifespan(float lifespan) {
        this.lifespan = lifespan;
    }
}

