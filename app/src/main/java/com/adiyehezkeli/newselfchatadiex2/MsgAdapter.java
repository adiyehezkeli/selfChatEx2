package com.adiyehezkeli.newselfchatadiex2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MsgAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Message> msgArray;
    private int numOfItems;

    public MsgAdapter(Context context, ArrayList<Message> msgs)
    {
        mContext = context;
        msgArray = msgs;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        numOfItems = msgs.size();
    }

//    @Override
//    public Message getItem(int i) {
//        return msgArray.get(i);
//    }

//    @NonNull
//    @Override
//    public Message onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.li_msg;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachParentImmidietly = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachParentImmidietly);
        MessageViewHolder viewHolder = new MessageViewHolder(view, this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position)
    {
        Message msg = msgArray.get(position);
        holder.timeStamp.setText(DateUtils.getRelativeTimeSpanString(holder.itemView.getContext(), msg.getTimeStamp()));
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return msgArray.size();
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View rowItem = mLayoutInflater.inflate(R.layout.li_msg, parent, false);
//
//        TextView msgName = (TextView) rowItem.findViewById(R.id.list_name);
//        TextView msgText = (TextView) rowItem.findViewById(R.id.list_text);
//        TextView msgTime = (TextView) rowItem.findViewById(R.id.list_time);
//
//        Message msgObj = getItem(position);
//
//        msgName.setText(msgObj.getName());
//        msgText.setText(msgObj.getMessage());
//        msgTime.setText(msgObj.getTimeStamp());
//
//        return rowItem;
//    }

    public void addMsg(Message newMsg)
    {
        msgArray.add(newMsg);
        notifyDataSetChanged();
    }

    public Message getItemById(int id)
    {
        return msgArray.get(id);
    }

    public void removeItem(Message msg) {
        for (int i = 0, size = msgArray.size(); i < size; i++) {
            if (msg.equals(msgArray.get(i))) {
                msgArray.remove(i);
                return;
            }
        }
    }
}
