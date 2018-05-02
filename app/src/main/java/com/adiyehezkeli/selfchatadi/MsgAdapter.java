package com.adiyehezkeli.selfchatadi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.adiyehezkeli.selfchatadi.Message;
import com.adiyehezkeli.selfchatadi.R;

import java.util.ArrayList;

public class MsgAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Message> msgArray;

    public MsgAdapter(Context context, ArrayList<Message> msgs)
    {
        mContext = context;
        msgArray = msgs;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return msgArray.size();
    }

    @Override
    public Message getItem(int i) {
        return msgArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        View rowItem = mLayoutInflater.inflate(R.layout.li_msg, parent, false);


        TextView msgName = (TextView) rowItem.findViewById(R.id.list_name);
        TextView msgText = (TextView) rowItem.findViewById(R.id.list_text);
        TextView msgTime = (TextView) rowItem.findViewById(R.id.list_time);

        holder = new ViewHolder();
        holder.getInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MessageFragment frag = MessageFragment.newInstance(message);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_message_layout, frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        Message msgObj = getItem(position);

        msgName.setText(msgObj.getName());
        msgText.setText(msgObj.getMessage());
        msgTime.setText(msgObj.getTimeStamp());

        return rowItem;
    }

    public void addMsg(Message newMsg)
    {
        msgArray.add(newMsg);
        notifyDataSetChanged();
    }

    class ViewHolder {

        TextView feedNumOfLikes;
        Button getInfo;

    }
}
