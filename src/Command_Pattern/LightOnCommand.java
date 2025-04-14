package Command_Pattern;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }


    @Override
    public void undo() {
        light.off();
    }
    public Light getLight() {
        return light;
    }
}