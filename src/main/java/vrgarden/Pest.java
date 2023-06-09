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
    public void Die(){}
}

