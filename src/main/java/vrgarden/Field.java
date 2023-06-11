package vrgarden;

/**
 * Superclass of classes such as: dirt, sand and other
 * blocks that can be placed on the garden grid
 */
public abstract class Field {
    public String fieldType;
    public float ph;
    public float temperature;
    public float sunAmount;
    public float wetness;
    public float rain;
    public String hostsPlants;

    public void MakeRain(){}
    public void StopRain(){}
    public void ChangeTemperature(){}
    public void ChangeSun(){}
    public void Flood(){}
}