package com.adiyehezkeli.selfchatadi;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        View layout = view.findViewById(R.id.fragment_message_layout);
//        TextView textView = view.findViewById(R.id.fragment_message_text);  

        //layout.setBackgroundColor( ContextCompat.getColor(getContext(), R.color.red)); 
//        textView.setText("I am a Fragment"); 

        return view;
    }

    public static MessageFragment newInstance(Message msg)
    {
        MessageFragment msgFrag = new MessageFragment();
        return msgFrag;
    }
}
