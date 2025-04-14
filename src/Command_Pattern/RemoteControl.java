package Command_Pattern;

public class RemoteControl {
    private final Command[] slots;

    public RemoteControl(int slotCount) {
        this.slots = new Command[slotCount];
    }

    public void setCommand(int slot, Command command) {
        slots[slot] = command;
    }

    public Command getCommand(int slot) {
        return slots[slot];
    }
}