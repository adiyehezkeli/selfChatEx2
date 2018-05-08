package com.adiyehezkeli.newselfchatadiex2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MessageViewHolder extends RecyclerView.ViewHolder{

    TextView name;
    TextView message;
    TextView timeStamp;
    MsgAdapter adapter;

    public MessageViewHolder(View itemView, MsgAdapter holderAdapter) {
        super(itemView);
        name = itemView.findViewById(R.id.list_name);
        message = itemView.findViewById(R.id.list_text);
        timeStamp = itemView.findViewById(R.id.list_time);
        adapter = holderAdapter;
    }
}
