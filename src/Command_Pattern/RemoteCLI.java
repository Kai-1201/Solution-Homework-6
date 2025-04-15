package Command_Pattern;
import java.util.List;
import java.util.Scanner;

public class RemoteCLI {
    private final RemoteControl remote;
    private final CommandHistory history;
    private final Thermostat thermostat;

    public RemoteCLI(RemoteControl remote, Thermostat thermostat) {
        this.remote = remote;
        this.history = new CommandHistory();
        this.thermostat = thermostat;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Turn on the light");
            System.out.println("2. Turn off the light");
            System.out.println("3. Set temperature");
            System.out.println("4. 'Comfort Mode' macro (light +22°C)");
            System.out.println("5. 'Night Mode' macro (light off +18°C)");
            System.out.println("6. Undo last command");
            System.out.println("7. Redo last command");
            System.out.println("0. Exit");
            System.out.print("Select action: ");

            try {
                int choice = in.nextInt();
                in.nextLine();

                switch (choice) {
                    case 1 -> history.execute(remote.getCommand(0));
                    case 2 -> history.execute(remote.getCommand(1));
                    case 3 -> {
                        System.out.print("Enter temperature:");
                        int temp = in.nextInt();
                        history.execute(new ThermostatCommand(thermostat, temp));
                    }
                    case 4 -> executeComfortMode();
                    case 5 -> executeNightMode();
                    case 6 -> history.undo();
                    case 7 -> history.redo();
                    case 0 -> { return; }
                    default -> System.out.println("Invalid input! Enter a number between 0 and 7");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number");
                in.nextLine();
            }
        }
    }

    private void executeNightMode() {
        Command cmd = remote.getCommand(1);
        if (!(cmd instanceof LightOffCommand)) {
            System.out.println("Configuration error: Light off command not found");
            return;
        }
        Light light = ((LightOffCommand)cmd).getLight();

        MacroCommand nightMode = new MacroCommand(List.of(
                new LightOffCommand(light),
                new ThermostatCommand(thermostat, 18)
        ));
        history.execute(nightMode);
    }

    private void executeComfortMode() {
        Light light = ((LightOnCommand)remote.getCommand(0)).getLight();
        MacroCommand comfortMode = new MacroCommand(List.of(
                new LightOnCommand(light),
                new ThermostatCommand(thermostat, 22)
        ));
        history.execute(comfortMode);
    }
}