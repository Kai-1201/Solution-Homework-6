package Chain_of_Responsibility;

public class HandlerLogger extends SupportHandler {
    private SupportHandler wrapped;

    public HandlerLogger(SupportHandler handler) {
        this.wrapped = handler;
    }
    @Override
    public boolean handle(String issue) {
        System.out.printf("[Logger] Handler %s received issue: %s\n",
                wrapped.getClass().getSimpleName(), issue);
        boolean result = wrapped.handle(issue);
        System.out.printf("[Logger] Handler %s %s the issue\n",
                wrapped.getClass().getSimpleName(),
                result ? "resolved" : "did not resolve");
        return result;
    }
}