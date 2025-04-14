package Chain_of_Responsibility;

public class JuniorSupportHandler extends SupportHandler {
    @Override
    public boolean handle(String issue) {
        if ("refund_request".equals(issue) || "billing_issue".equals(issue)) {
            System.out.println("[Junior Support] Handled " + issue);
            return true;
        }
        return nextHandler != null && nextHandler.handle(issue);
    }
}