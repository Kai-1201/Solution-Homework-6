package Command_Pattern;

public class Main {
    public static void main(String[] args) {
        Light light = new Light("Living room");
        Thermostat thermo = new Thermostat();

        RemoteControl remote = new RemoteControl(2);
        remote.setCommand(0, new LightOnCommand(light));
        remote.setCommand(1, new LightOffCommand(light));
        RemoteCLI cli = new RemoteCLI(remote, thermo);
        cli.start();
    }
}