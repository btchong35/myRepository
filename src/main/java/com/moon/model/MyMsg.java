package com.moon.model;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2020/4/30
 * @since 1.0.0
 */
public class MyMsg {
    private String sender;
    private String receiver;
    private String content;
    private String time;

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyMsg{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public MyMsg(String sender, String receiver, String content, String time) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.time = time;
    }
}