package Command_Pattern;

public class Thermostat {
    private int currentTemperature = 20;
    private int previousTemperature;

    public void setTemperature(int temp) {
        previousTemperature = currentTemperature;
        currentTemperature = temp;
        System.out.println("[Thermostat] Temperature set to " + temp + "°C");
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }
}