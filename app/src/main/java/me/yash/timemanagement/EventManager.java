package me.yash.timemanagement;

import java.util.ArrayList;

/**
 * Created by Yash on 4/11/2018.
 */

public class EventManager {
    private ArrayList<Event> events = new ArrayList<Event>();

    EventManager(){

    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public int findEvent(int eventIndex){
        for (int i = 0 ; i <= events.size(); i++){
            if(events.get(i).getEventIndex() == eventIndex){
                return eventIndex;
            }
        }
        return -1;
    }
}
