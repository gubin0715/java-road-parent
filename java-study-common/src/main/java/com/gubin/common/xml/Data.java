package com.gubin.common.xml;

public class Data {
    public static final String headInfo="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private Head head;
    private Body body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
