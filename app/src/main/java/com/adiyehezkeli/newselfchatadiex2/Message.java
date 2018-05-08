package com.adiyehezkeli.newselfchatadiex2;

public class Message {

    private String name;
    private String message;
    private long timeStamp;

    public Message(String aName, String msg, long time)
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

    public long getTimeStamp() {
        return timeStamp;
    }
}
