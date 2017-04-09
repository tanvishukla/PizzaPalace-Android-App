package com.example.hemil.papa_johns.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hemil.papa_johns.R;

/**
 * Created by hemil on 11/18/2015.
 */
public class ItemListAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] chooseItemsText;
    private final int[] mThumbsId;

    public ItemListAdapter(Context c, String[] chooseItemsText, int[] mThumbsId){
        mContext = c;
        this.chooseItemsText = chooseItemsText;
        this.mThumbsId = mThumbsId;
    }

    public int getCount(){  return mThumbsId.length;    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View list;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            list = new View(mContext);
            list = inflater.inflate(R.layout.listview_single,null);
            ImageView imageView = (ImageView) list.findViewById(R.id.itemImage);
            TextView textView = (TextView) list.findViewById(R.id.itemNameImage);
            imageView.setImageResource(mThumbsId[position]);
            textView.setText(chooseItemsText[position]);
        }
        else list = convertView;
        return list;
    }
}
