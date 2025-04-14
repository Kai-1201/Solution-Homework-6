package Chain_of_Responsibility;

public class SeniorSupportHandler extends SupportHandler {
    @Override
    public boolean handle(String issue) {
        if ("account_ban".equals(issue) || "data_loss".equals(issue)) {
            System.out.println("[Senior Support] Handled critical issue: " + issue);
            return true;
        }
        System.out.println("[Senior Support] Cannot handle '" + issue + "' - needs manual escalation");
        return false;
    }
}