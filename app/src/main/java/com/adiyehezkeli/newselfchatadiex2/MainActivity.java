package com.adiyehezkeli.newselfchatadiex2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Timestamp;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MessageFragment.MessageDeletedListener{

    private RecyclerView msgDisplay;
    private Button sendButton;
    private MsgAdapter adapter;
    private EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgDisplay = findViewById(R.id.recycler_list);
        sendButton = findViewById(R.id.send_button);

        ArrayList<Message> msgArray = new ArrayList<Message>();

        adapter = new MsgAdapter(this, msgArray);
        msgDisplay.setAdapter(adapter);

        msgDisplay.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MessageFragment currentFragment = new MessageFragment();
                getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_message_layout, currentFragment)
                .commit();
                return true;
            }
        });
    }

    public void sendMessage(View view)
    {
        input = findViewById(R.id.text_edit_location);
        if (!TextUtils.isEmpty(input.getText())) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Message newMsg = new Message("Adi", input.getText().toString(), Long.parseLong(timestamp.toString()));
            adapter.addMsg(newMsg);
            input.setText("");
        }

    }

    @Override
    public void onMessageDeleted(Message msg) {
        adapter.removeItem(msg);
    }
}
