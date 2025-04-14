package Command_Pattern;

public class Light {
    private String location;
    private boolean isOn;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        System.out.println("[Light] " + location + " light is ON");
    }


    public void off() {
        isOn = false;
        System.out.println("[Light] " + location + " light is OFF");
    }
}