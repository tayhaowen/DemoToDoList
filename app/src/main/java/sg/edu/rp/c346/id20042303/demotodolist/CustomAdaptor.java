package sg.edu.rp.c346.id20042303.demotodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdaptor extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> versionList;

    public CustomAdaptor(Context context, int resource, ArrayList<ToDoItem> object){
        super(context, resource, object);

        parent_context = context;
        layout_id = resource;
        versionList = object;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        // Obtain the Android Version information based on the position
        ToDoItem currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        if(currentVersion.getDate().get(Calendar.YEAR) == 2021){
            tvDate.setTextColor(Color.parseColor("#FF0000"));
        }
        tvTitle.setText(currentVersion.getTitle());
        tvDate.setText(currentVersion.toString());

        return rowView;
    }
}
