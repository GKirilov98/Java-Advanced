package p01_EventInvetory;

import java.util.EventObject;

class Event extends EventObject {
    private String changedName;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    Event(Object source, String changedName) {
        super(source);
        this.changedName = changedName;
    }

    String getChangedName() {
        return this.changedName;
    }
}
