package garden.virtualgarden;

public class F0 extends Field{
    F0(){
        this.fieldType = "Dirt";
        this.ph = 8;
        this.temperature = 25.6f;
        this.sunAmount = 7;
        this.wetness = 8;
        this.rain = 0;
        this.hostsPlants = "Cabbage";
    }
    
    F0(String fieldType, float ph, float temperature, float sunAmount, float wetness, float rain, String hostsPlants){
        this.fieldType = fieldType;
        this.ph = ph;
        this.temperature = temperature;
        this.sunAmount = sunAmount;
        this.wetness = wetness;
        this.rain = rain;
        this.hostsPlants = hostsPlants;
    }

    F0(F0 f0){
        this.fieldType = f0.fieldType;
        this.ph = f0.ph;
        this.temperature = f0.temperature;
        this.sunAmount = f0.sunAmount;
        this.wetness = f0.wetness;
        this.rain = f0.rain;
        this.hostsPlants = f0.hostsPlants;
    }
}