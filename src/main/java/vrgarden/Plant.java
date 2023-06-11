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
    String plantType;

    public void MakeSeed(){}
    public void SpreadAmount(){}
    public void Mutate(){}

    /////////////////////////
    /////////GETTERS/////////
    /////////////////////////

    public float getLifespan() {
        return this.lifespan;
    }
    public String getPlantType(){ return this.plantType; }

    /////////////////////////
    /////////SETTERS/////////
    /////////////////////////
    public void setLifespan(float lifespan) {
        this.lifespan = lifespan;
    }
}

