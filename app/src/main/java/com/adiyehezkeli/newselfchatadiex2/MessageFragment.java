package com.adiyehezkeli.newselfchatadiex2;

import android.annotation.SuppressLint;
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

public class MessageFragment extends android.support.v4.app.Fragment {

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        View layout = view.findViewById(R.id.fragment_message_layout);
        TextView textView = view.findViewById(R.id.fragment_message_text);
        layout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        textView.setText("I am a Fragment");

        return view;
    }

    public static MessageFragment newInstance(Message msg)
    {
        MessageFragment msgFrag = new MessageFragment();
        return msgFrag;
    }

    public interface MessageDeletedListener {
        void onMessageDeleted(Message msg);
    }
}
