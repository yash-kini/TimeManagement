package me.yash.timemanagement;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private LinearLayout list;
    private FloatingActionButton fab;
    public static ClickManager cm;
    public static EventManager ev = new EventManager();
    public static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout list = (LinearLayout) findViewById(R.id.list);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        cm = new ClickManager(fab);


        Calendar startTime = Calendar.getInstance();
        final Calendar endTime = Calendar.getInstance();

        startTime.set(Calendar.HOUR_OF_DAY, 9);
        endTime.set(Calendar.HOUR_OF_DAY, 1);
        endTime.add(Calendar.DATE, 1);

        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.SECOND, 0);
        endTime.set(Calendar.MILLISECOND, 0);
        TextView text = new TextView(getApplicationContext());
        text.setText("AHHHHHHHHH");
        //list.addView(text);

        //Instantiate Clicks Manager
        fab.hide();


        final Context con = getApplicationContext();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence options[] = new CharSequence[]{"Call", "SMS", "Email"};

                AlertDialog.Builder builder = new AlertDialog.Builder(con);
                builder.setCancelable(false);
                builder.setTitle("Select your option:");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // the user clicked on options[which]
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //the user clicked on Cancel
                    }
                });
                builder.show();

            } });
        populateList(startTime, endTime, 15, list);


    }

    public void populateList(Calendar startTime,Calendar endTime, int minInt, LinearLayout list) {
        Calendar curTime = (Calendar) startTime.clone();
        count = 0;
        while (curTime.getTimeInMillis() < endTime.getTimeInMillis()) {
            Event e = new Event(curTime, getApplicationContext(), count);
            e.setClickManager();
            list.addView(e.getView());
            curTime.add(Calendar.MINUTE, minInt);
            count++;
        }
    }
}
