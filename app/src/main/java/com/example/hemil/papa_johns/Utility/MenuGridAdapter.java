package com.example.hemil.papa_johns.Utility;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hemil.papa_johns.R;

/**
 * Created by hemil on 11/17/2015.
 */
public class MenuGridAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] menuItemsText;
    private final int[] mThumbsId;

    public MenuGridAdapter(Context context, String[] menuItemsText, int[] mThumbsId){
        mContext = context;
        this.menuItemsText = menuItemsText;
        this.mThumbsId = mThumbsId;
    }

    public int getCount(){
        return mThumbsId.length;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position,View convertView, ViewGroup parent){
       View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single,null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(menuItemsText[position]);
            imageView.setImageResource(mThumbsId[position]);

        }
        else grid = (View) convertView;
        return grid;
    }

}
