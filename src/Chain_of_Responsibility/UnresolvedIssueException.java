package Chain_of_Responsibility;

public class UnresolvedIssueException extends RuntimeException {
    public UnresolvedIssueException(String issue) {
        super("No handler could resolve issue: " + issue);
    }
}