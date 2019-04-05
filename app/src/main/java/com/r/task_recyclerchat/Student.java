package com.r.task_recyclerchat;

class Student {

    static final int chat_left = 0;
    static final int chat_right = 1;

    int type;
    String text;

    Student(int type, String text) {
        this.type = type;
        this.text = text;
    }
}
