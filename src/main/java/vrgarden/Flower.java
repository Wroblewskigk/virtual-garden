package vrgarden;

public class Flower extends Plant{
    Flower(){
        super();
        this.plantType = "Flower";
    }

    /**
     * A method that makes Object that inherit Pest class
     * move towards flower object in order to consume it
     */
    public void AttractPest(){}
}
