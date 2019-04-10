package me.yash.timemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Yash on 12/7/2017.
 */

public class Event {
    private Calendar time;
    private Activity activity;
    private View view;
    private int eventIndex;
    private SimpleDateFormat sdf = new SimpleDateFormat("H:mm");

    Event(Calendar time, Context con, int eventIndex){
        this.time = time;
        LayoutInflater inflater = (LayoutInflater) con.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        view = inflater.inflate(R.layout.list_item, null);
        TextView text = (TextView) view.findViewById(R.id.time);
        text.setText(sdf.format(time.getTime()));
        MainActivity.ev.getEvents().add(this);
        this.eventIndex = eventIndex;
    }

    public void setClickManager() {
        this.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = eventIndex;
                System.out.println(temp);
                MainActivity.cm.addClick(MainActivity.ev.getEvents().get(temp));
            }
        });
    }

    public void setActivity(Activity activity){
        this.activity = activity;
    }

    public Calendar getTime() {
        return time;
    }

    public Activity getActivity() {
        return activity;
    }

    public View getView() {
        return view;
    }

    public int getEventIndex() {
        return eventIndex;
    }


    public String toString(){
        return "Time: "+time.getTime()+"\nIndex: "+eventIndex;
    }
}
