package com.example.hemil.papa_johns.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.Memento.Omemento;
import com.example.hemil.papa_johns.POJO.Order;
import com.example.hemil.papa_johns.R;

import java.util.List;

/**
 * Created by hemil on 11/29/2015.
 */
public class OrderListAdapter extends BaseAdapter {

    private Context mContext;
    List<Omemento> orderList;
    public OrderListAdapter(Context c, List<Omemento> list){
        mContext = c;
        this.orderList = list;
    }

    public int getCount(){  return orderList.size();    }

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
            list = inflater.inflate(R.layout.order_single,null);

        }
        else list = convertView;
        TextView nameText = (TextView) list.findViewById(R.id.orderName);
        TextView costText = (TextView) list.findViewById(R.id.orderCost);
        nameText.setText(orderList.get(position).getState().getOrderName());
        costText.setText(""+orderList.get(position).getState().getCost());
     //   Button button = (Button) convertView.findViewById(R.id.remove);
     //   button.setOnClickListener(new View.OnClickListener() {
    //        @Override
    //        public void onClick(View v) {
        //        Toast.makeText(getApplicationContext, "Make an Method Here", Toast.LENGTH_SHORT).show();
     //       }
      //  });
        return list;
    }
}
