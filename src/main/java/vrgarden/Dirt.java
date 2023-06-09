package vrgarden;

public class Dirt extends Field{
    Dirt(){
        this.fieldType = "Dirt";
        this.ph = 8;
        this.temperature = 25.6f;
        this.sunAmount = 7;
        this.wetness = 8;
        this.rain = 0;
        this.hostsPlants = "Cabbage";
    }

    Dirt(String fieldType, float ph, float temperature, float sunAmount, float wetness, float rain, String hostsPlants){
        this.fieldType = fieldType;
        this.ph = ph;
        this.temperature = temperature;
        this.sunAmount = sunAmount;
        this.wetness = wetness;
        this.rain = rain;
        this.hostsPlants = hostsPlants;
    }

    Dirt(Dirt dirt){
        this.fieldType = dirt.fieldType;
        this.ph = dirt.ph;
        this.temperature = dirt.temperature;
        this.sunAmount = dirt.sunAmount;
        this.wetness = dirt.wetness;
        this.rain = dirt.rain;
        this.hostsPlants = dirt.hostsPlants;
    }
}