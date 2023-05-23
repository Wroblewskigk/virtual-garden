package garden.virtualgarden;

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
}