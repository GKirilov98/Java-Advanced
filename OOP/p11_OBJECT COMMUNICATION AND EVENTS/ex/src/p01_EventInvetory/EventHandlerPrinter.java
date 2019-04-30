package p01_EventInvetory;

public class EventHandlerPrinter implements NameChangeListener {
    @Override
    public void handleChangedName(Event event) {
        System.out.println("Dispatcher's name changed to " + event.getChangedName() + "." );
    }
}
