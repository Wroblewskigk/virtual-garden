package garden.virtualgarden;

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