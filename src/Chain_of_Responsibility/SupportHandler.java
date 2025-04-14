package Chain_of_Responsibility;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public SupportHandler setNext(SupportHandler next) {
        this.nextHandler = next;
        return next;
    }
    public abstract boolean handle(String issue);
}