package garden.virtualgarden;

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
}