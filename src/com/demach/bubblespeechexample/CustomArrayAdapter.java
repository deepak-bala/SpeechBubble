package com.demach.bubblespeechexample;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String>
{
    private Context context;
    
    public CustomArrayAdapter(Context context, int textViewResourceId, List<String> objects)
    {
        super(context, textViewResourceId, objects);
        this.context = context;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, parent, false);
        }
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        TextView message = (TextView) convertView.findViewById(R.id.message);
        image.setImageResource(R.drawable.ic_launcher);
        message.setText(getItem(position));
        return convertView;
    }

}
