package com.adiyehezkeli.selfchatadi;

public class Message {

    private String name;
    private String message;
    private String timeStamp;

    public Message(String aName, String msg, String time)
    {
        name = aName;
        message = msg;
        timeStamp = time;
    }

    public String getMessage()
    {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
