package com.makeinfo.flowerpi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.makeinfo.flowerpi.model.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class adapter extends ArrayAdapter<Datum> {

    // String url="http://services.hanselandpetal.com/photos/";
    private Context context;
    private List<Datum> datumList;
    public adapter(Context context, int resource, List<Datum> objects) {
        super(context, resource, objects);
        this.context = context;
        this.datumList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_file,parent,false);
        Datum video = datumList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.name);
        tv.setText(video.title);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Picasso.with(getContext()).load(video.hdposterurl).resize(320,180).into(img);
        return view;
    }
}