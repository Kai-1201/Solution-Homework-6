package Chain_of_Responsibility;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SupportHandler faq = new HandlerLogger(new FAQBotHandler());
        SupportHandler junior = new HandlerLogger(new JuniorSupportHandler());
        SupportHandler senior = new HandlerLogger(new SeniorSupportHandler());

        SupportHandler chain = DynamicChainConfigurator.createChain(
                Arrays.asList(faq, junior, senior)
        );
        String[] issues = {"password_reset", "unknown_problem", "billing_issue"};
        for (String issue : issues) {
            try {
                if (!chain.handle(issue)) {
                    throw new UnresolvedIssueException(issue);
                }
            } catch (UnresolvedIssueException e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        }
    }
}