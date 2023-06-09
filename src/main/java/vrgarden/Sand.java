package vrgarden;

public class Sand extends Field{
    Sand(){
        this.fieldType = "Sand";
        this.ph = 7;
        this.temperature = 30.6f;
        this.sunAmount = 12;
        this.wetness = 3;
        this.rain = 0;
        this.hostsPlants = "Cabbage";
    }

    Sand(String fieldType, float ph, float temperature, float sunAmount, float wetness, float rain, String hostsPlants){
        this.fieldType = fieldType;
        this.ph = ph;
        this.temperature = temperature;
        this.sunAmount = sunAmount;
        this.wetness = wetness;
        this.rain = rain;
        this.hostsPlants = hostsPlants;
    }

    Sand(Sand sand){
        this.fieldType = sand.fieldType;
        this.ph = sand.ph;
        this.temperature = sand.temperature;
        this.sunAmount = sand.sunAmount;
        this.wetness = sand.wetness;
        this.rain = sand.rain;
        this.hostsPlants = sand.hostsPlants;
    }
}