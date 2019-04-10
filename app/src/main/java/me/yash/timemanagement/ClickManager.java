package me.yash.timemanagement;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.widget.LinearLayout;

import java.util.Calendar;

/**
 * Created by Yash on 12/18/2017.
 */

public class ClickManager {
    private int clicks = 0;
    private Event first;
    private Event second;
    private  FloatingActionButton fab;
    ClickManager(FloatingActionButton fab){
        this.fab = fab;
    }

    public void addClick(Event e){
        System.out.print(e);
        clicks++;
        if (clicks == 1){
            first = e;
            e.getView().setBackgroundResource(R.color.colorAccent);
            fab.show();

        }
        else if (clicks == 2) {
            second = e;
            int fIndex = first.getEventIndex();
            int sIndex = second.getEventIndex();
            //System.out.println("fIndex: "+fIndex);
            //System.out.println("sIndex: "+ sIndex);
            if (fIndex > sIndex){
                for (int i = sIndex; i <= fIndex; i++){
                    MainActivity.ev.getEvents().get(i).getView().setBackgroundResource(R.color.colorAccent);
                }
            }
            if (sIndex > fIndex){
                for (int i = fIndex; i <= sIndex; i++){
                    MainActivity.ev.getEvents().get(i).getView().setBackgroundResource(R.color.colorAccent);
                }
            }
            if (sIndex == fIndex) {
                clicks = 0;
                first.getView().setBackgroundResource(R.color.white);
            }
        }
        else {
            fab.hide();
            clicks = 0;
            for (int i = 0; i < MainActivity.ev.getEvents().size(); i++){
                MainActivity.ev.getEvents().get(i).getView().setBackgroundResource(R.color.white);
            }
        }
        //System.out.println("Clicks: "+clicks);
    }
}
