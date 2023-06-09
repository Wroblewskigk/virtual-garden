package vrgarden;

public class Grass extends Field{
    Grass(){
        this.fieldType = "Grass";
        this.ph = 9;
        this.temperature = 22.6f;
        this.sunAmount = 8;
        this.wetness = 10;
        this.rain = 12;
        this.hostsPlants = "Cabbage";
    }

    Grass(String fieldType, float ph, float temperature, float sunAmount, float wetness, float rain, String hostsPlants){
        this.fieldType = fieldType;
        this.ph = ph;
        this.temperature = temperature;
        this.sunAmount = sunAmount;
        this.wetness = wetness;
        this.rain = rain;
        this.hostsPlants = hostsPlants;
    }

    Grass(Grass grass){
        this.fieldType = grass.fieldType;
        this.ph = grass.ph;
        this.temperature = grass.temperature;
        this.sunAmount = grass.sunAmount;
        this.wetness = grass.wetness;
        this.rain = grass.rain;
        this.hostsPlants = grass.hostsPlants;
    }
}