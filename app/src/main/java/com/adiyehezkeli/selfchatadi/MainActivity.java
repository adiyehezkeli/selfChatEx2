package com.adiyehezkeli.selfchatadi;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Timestamp;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView msgDisplay;
    private Button sendButton;
    private MsgAdapter adapter;
    private EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        MessageFragment messageFragment = new MessageFragment();
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.activity_main_frame, messageFragment)
//                .commit();

        msgDisplay = findViewById(R.id.the_msg_display);
        sendButton = findViewById(R.id.send_button);

        ArrayList<Message> msgArray = new ArrayList<Message>();

        adapter = new MsgAdapter(this, msgArray);
        msgDisplay.setAdapter(adapter);
    }

    public void sendMessage(View view)
    {
        input = findViewById(R.id.text_edit_location);
        if (!TextUtils.isEmpty(input.getText())) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Message newMsg = new Message("Adi", input.getText().toString(), timestamp.toString());
            adapter.addMsg(newMsg);
            input.setText("");
        }
    }


    //
//    @Override
//    public void onClick(MessagePojo message) {
//        MessageDetailsFragment frag = MessageDetailsFragment.newInstance(message);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.frame, frag)
//                .addToBackStack(null)
//                .commit();
//    }
}
