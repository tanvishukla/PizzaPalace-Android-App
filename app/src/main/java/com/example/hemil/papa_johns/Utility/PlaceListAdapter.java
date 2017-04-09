package com.example.hemil.papa_johns.Utility;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hemil.papa_johns.R;

/**
 * Created by hemil on 12/4/2015.
 */
public class PlaceListAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] chooseItemsText;

    public PlaceListAdapter(Context mContext,String[] chooseItemsText){

        this.mContext = mContext;
        this.chooseItemsText = chooseItemsText;
    }

    @Override
    public int getCount() {
        return chooseItemsText.length;
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
       View list;
        Log.d("Place",""+position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(convertView == null){
                list = new View(mContext);
                list = inflater.inflate(R.layout.place_single,null);
                TextView textview = (TextView) list.findViewById(R.id.storeAddressText);
                textview.setText(chooseItemsText[position]);
            }

            else list = convertView;

        return  list;
    }
}
