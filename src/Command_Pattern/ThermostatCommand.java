package Command_Pattern;

public class ThermostatCommand implements Command {
    private Thermostat thermostat;
    private int targetTemperature;
    private int previousTemperature;

    public ThermostatCommand(Thermostat thermostat, int temp) {
        this.thermostat = thermostat;
        this.targetTemperature = temp;
    }

    @Override
    public void execute() {
        previousTemperature = thermostat.getCurrentTemperature();
        thermostat.setTemperature(targetTemperature);
    }

    @Override
    public void undo() {
        thermostat.setTemperature(previousTemperature);
    }

}