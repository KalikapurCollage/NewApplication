package com.example.newapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomAdapter extends BaseAdapter {

    int[] busImage;
    String[] busName, busTime;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] busName, String[] busTime, int[] busImage){
        this.context = context;
        this.busName = busName;
        this.busTime = busTime;
        this.busImage = busImage;

    }

    @Override
    public int getCount() {
        return busName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bus_adapter,parent,false);
        }

        ImageView imageView;
        TextView textView, textView1;

        imageView = convertView.findViewById(R.id.busImageId);
        textView = convertView.findViewById(R.id.busNameId);
        textView1 = convertView.findViewById(R.id.busTimeid);

        imageView.setImageResource(busImage[0]);
        textView.setText(busName[position]);
        textView1.setText(busTime[position]);

        return convertView;
    }
}
