package p01_EventInvetory;


import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> allChangedNameListeners;

    Dispatcher() {
        this.name = "";
        this.allChangedNameListeners = new ArrayList<>();
    }

    void addNameChangeListener(NameChangeListener  observer){
       this.allChangedNameListeners.add(observer);
    }

     void removeNameChangeListener(NameChangeListener  observer){
        this.allChangedNameListeners.remove(observer);
    }

    private void fireNameChangeEvent(){
        Event event = new Event(this, this.name);
        for (NameChangeListener observer : allChangedNameListeners) {
            observer.handleChangedName(event);
        }
    }

     void setName(String name){
        this.name = name;
      this.fireNameChangeEvent();
    }


}
