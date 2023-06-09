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
}