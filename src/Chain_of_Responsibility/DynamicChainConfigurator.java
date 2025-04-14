package Chain_of_Responsibility;

import java.util.List;

public class DynamicChainConfigurator {
    public static SupportHandler createChain(List<SupportHandler> handlers) {
        if (handlers.isEmpty()) {
            throw new IllegalArgumentException("No handlers provided");
        }
        SupportHandler first = handlers.get(0);
        SupportHandler current = first;

        for (int i = 1; i < handlers.size(); i++) {
            current = current.setNext(handlers.get(i));
        }
        return first;
    }
}