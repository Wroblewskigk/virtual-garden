package vrgarden;

/**
 * Superclass of classes such as: dirt, sand and other
 * blocks that can be placed on the garden grid
 */
public abstract class Field {
    String fieldType;
    float ph;
    float temperature;
    float sunAmount;
    float wetness;
    float rain;
    String hostsPlants;

    public void MakeRain(){}
    public void StopRain(){}
    public void ChangeTemperature(){}
    public void ChangeSun(){}
    public void Flood(){}
}