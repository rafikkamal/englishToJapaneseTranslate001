package com.example.rafik.translatetojapaneseappprototype001;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends  ArrayAdapter<String> {
    public CustomAdapter(Context context, String[] menuItem) {
        super(context, R.layout.custom_row, menuItem);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row,parent,false);

        String singleMenuItem = getItem(position);
        TextView singleMenuItemText = (TextView)customView.findViewById(R.id.customRowText);
        ImageView singleMenuItemImage = (ImageView)customView.findViewById(R.id.customRowImage);

        singleMenuItemText.setText(singleMenuItem);
        singleMenuItemImage.setImageResource(R.drawable.japan_flag);

        return customView;

    }
}
