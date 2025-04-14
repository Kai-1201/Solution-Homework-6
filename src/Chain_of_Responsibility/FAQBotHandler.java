package Chain_of_Responsibility;

public class FAQBotHandler extends SupportHandler {
    @Override
    public boolean handle(String issue) {
        if ("password_reset".equals(issue)) {
            System.out.println("[FAQ Bot] Handled password reset request");
            return true;
        }
        return nextHandler != null && nextHandler.handle(issue);
    }
}