package Chain_of_Responsibility;

public class Main {
    public static void main(String[] args) {
        SupportHandler faqHandler = new FAQBotHandler();
        SupportHandler juniorHandler = new JuniorSupportHandler();
        SupportHandler seniorHandler = new SeniorSupportHandler();

        faqHandler.setNext(juniorHandler).setNext(seniorHandler);

        String[] testIssues = {
                "password_reset",
                "billing_issue",
                "data_loss",
                "unknown_issue"
        };

        for (String issue : testIssues) {
            System.out.println("\nProcessing issue: " + issue);
            boolean wasHandled = faqHandler.handle(issue);

            if (!wasHandled) {
                System.out.println("No handler could process: " + issue);
            }
        }
    }
}