package Command_Pattern;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }


    @Override
    public void undo() {
        light.on();
    }

    public Light getLight() {
        return light;
    }
}